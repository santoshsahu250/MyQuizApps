package com.school.Quiz.vo;

public class StudentDetails {

	private String schoolName;
	private String studentName;
	private String rollNo;
	private String clazz;

	public StudentDetails() {
		super();
	}

	public StudentDetails(String schoolName, String studentName, String rollNo, String clazz) {
		super();
		this.schoolName = schoolName;
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.clazz = clazz;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}
