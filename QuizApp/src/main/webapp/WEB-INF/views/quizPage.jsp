<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

            <!-- Static content -->
            <link rel="stylesheet" href="/resources/css/w3.css">

	            <title>${headerlable}</title>
		</head>

        <body>
            <div class="w3-container w3-indigo">
                 <h1>${headerlable}</h1>
            <lable class="w3-large">&nbsp; &nbsp; &nbsp;${developer}</lable>
            </div>
            <hr>

            <div class="w3-panel w3-light-grey w3-bottombar w3-grey w3-border">
                <h2>${stuDetails.studentName}</h2>
                <p>
                   <!--  
                   <label>Roll No</label>&nbsp; : &nbsp;
                    <label>${stuDetails.rollNo}</label>
                    &nbsp; &nbsp;
                    <label>Class</label>&nbsp; : &nbsp;
                    <label>${stuDetails.clazz}</label>
                    &nbsp; &nbsp;
                    -->
                    <label class="w3-large">School</label>&nbsp; : &nbsp;
                    <label class="w3-large">${stuDetails.schoolName}</label>

                </p>

            </div>
  <label class="w3-deep-purple w3-large">Total Question : ${qlistSize}</label>
  <input id="qlistSize" name="qlistSize" type="hidden">
  <br>
  <form action="complete" method="post"  class="w3-container">
		<c:forEach items="${qlist}" var="element"> 
			<ul class="w3-ul w3-hover-pale-yellow">
				<li class="w3-large">${element.qid} : ${element.qDetails} </li>
				<li>
				<input class="w3-radio" type="radio" name="Qid_${element.qid}" value="${element.option1}" >
				<label class="w3-large">${element.option1}</label>
				</li>
				<li>
				<input class="w3-radio" type="radio" name="Qid_${element.qid}" value="${element.option2}" >
				<label class="w3-large">
				${element.option2}
				</li>
				<li>
				<input class="w3-radio" type="radio" name="Qid_${element.qid}" value="${element.option3}" >
				<label class="w3-large">${element.option3}
				</li>
				<li>
				<input class="w3-radio" type="radio" name="Qid_${element.qid}" value="${element.option4}" >
				<label class="w3-large">${element.option4}
				</li>		
			</ul>
			
			<br><br>
		</c:forEach>
	<input type="submit" value="Submit Answer" class="w3-button w3-indigo w3-large" style="float: right;">
	</form>
</body>

        </html>