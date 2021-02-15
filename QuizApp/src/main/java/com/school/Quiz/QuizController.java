package com.school.Quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.Quiz.vo.Question;
import com.school.Quiz.vo.StudentDetails;

@Controller
public class QuizController {
	@Autowired
	private Environment env;
	int correctCount=0;
	@RequestMapping("/")
	public String index( HttpServletRequest request) {
		sessionCleanup(request);
		setCommonProperties(request);
		
		return "loginHome";
	}

	@PostMapping("/login")
	public String login(@RequestParam("name") String name, @RequestParam(value="roll",required = false) String roll,
			@RequestParam(value="clazz",required = false) String clazz, @RequestParam("school") String school, @RequestParam("pwd") String pwd,
			Model model, HttpServletRequest request) {
		System.out.println(name);
		System.out.println(school);
		
		if(name==null || name.isEmpty()) {
			model.addAttribute("loginError", "Name is missing");
			return "loginHome";
		}
		if(!passwordCheck(pwd)) {
			model.addAttribute("loginError", "Password is incorrect");
			return "loginHome";
		}
		
		StudentDetails sd = new StudentDetails(school, name, roll, clazz);
		request.getSession().setAttribute("stuDetails", sd);
		model.addAttribute("qlist", generateQuestionList(request));
		request.getSession().setAttribute("qlistSize", generateQuestionList(request).size());
		return "quizPage";
	}
	
	@PostMapping("/complete")
	public String submitAnswer(	Model model, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("stuDetails")==null) {
			model.addAttribute("loginError", "Session Expired");
			return "loginHome";
		}
		
		int qcount=(int) request.getSession().getAttribute("qlistSize");
		Map<Integer,String> answerMapByStudent=new HashMap<Integer,String>();
		for(int i = 1; i <= qcount; i++) {
			answerMapByStudent.put(i, request.getParameter("Qid_"+i));
		}
		model.addAttribute("answerList", processResult(answerMapByStudent, generateQuestionList(request)));
		model.addAttribute("score", correctCount);
		
		return "resultPage";
	}

	
	private List<Question> generateQuestionList(HttpServletRequest request) {

		List<Question> list = new ArrayList<Question>();
		for (int i = 1; i < 51; i++) {
			if (env.getProperty("Question" + i) != null && !env.getProperty("Question" + i).isEmpty()) {
				Question q = new Question();
				q.setQid(i);
				q.setqDetails(env.getProperty("Question" + i).trim());
				q.setOption1(env.getProperty("Option" + i + "A").trim());
				q.setOption2(env.getProperty("Option" + i + "B").trim());
				q.setOption3(env.getProperty("Option" + i + "C").trim());
				q.setOption4(env.getProperty("Option" + i + "D").trim());
				q.setAnswer(env.getProperty("Answer" + i).trim());
				list.add(q);
			}

		}
		return list;

	}

	private void setCommonProperties(HttpServletRequest request) {
		request.getSession().setAttribute("schoolList", generateSchoolList());
		request.getSession().setAttribute("headerlable", env.getProperty("lable.header"));
		request.getSession().setAttribute("developer", env.getProperty("label.developer"));

	}
	
	private boolean passwordCheck(String password) {
		String correctPassword=env.getProperty("app.password");
		return correctPassword.equals(password);
	}
	
	private List<String> generateSchoolList() {

		List<String> list = new ArrayList<String>();
		int count=Integer.parseInt(env.getProperty("school.count"));
		for (int i = 1; i <= count; i++) {
			if (env.getProperty("school" + i) != null && !env.getProperty("school" + i).isEmpty()) {
				list.add(env.getProperty("school" + i).trim());
			}

		}
		return list;

	}
	
	private List<Question> processResult(Map<Integer,String> answerMapByStudent,List<Question> questionList){
		correctCount=0;
		for(Question question:questionList) {
			question.setStudentAnswer(answerMapByStudent.get(question.getQid()));
			if(question.getAnswer().equals(question.getStudentAnswer())) {
				question.setResult("Y");
				correctCount++;
			}else {
				question.setResult("N");
			}
			
		}
		return questionList;
		
	}
	
	private void sessionCleanup(HttpServletRequest request) {
		request.getSession().removeAttribute("stuDetails");
		request.getSession().removeAttribute("qlistSize");
		request.getSession().removeAttribute("schoolList");
		request.getSession().removeAttribute("headerlable");
		request.getSession().removeAttribute("developer");
		}

	private void writeTofile(String name, String school ,int score) {
		Path path = Paths.get("./result_"+name+"_"+System.currentTimeMillis()+".txt");
		try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
		writer.write(""+name+"	,	"+school+"	,	 "+score);
		}catch(IOException ex){
		ex.printStackTrace();
		}
	}
}
