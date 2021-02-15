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
  <br>
  <label class="w3-deep-purple w3-large">Marks : </label>  &nbsp; &nbsp;   <span class="w3-badge w3-xxlarge w3-padding w3-green">${score}</span>
     
<br>
  <br>
  
		<c:forEach items="${answerList}" var="element"> 
			<ul class="w3-ul w3-hover-pale-yellow">
				<li class="w3-large"> ${element.qid} : ${element.qDetails} </li>
				<li>
				

					<c:if  test="${element.result eq 'Y'}">
           			<!--  Correct-->
           			  <label class="w3-large">-  ${element.studentAnswer}</label>  &nbsp; &nbsp; <span class="w3-badge w3-green w3-xlarge">1</span>
         			</c:if>
					<c:if test="${element.result eq 'N'}">
					<!-- Wrong -->
           			 -<label class="w3-tag w3-red w3-large">   ${element.studentAnswer}</label>  &nbsp; &nbsp; &nbsp; &nbsp; <label class="w3-large">Correct Answer : ${element.answer}</label>
         			</c:if>

		
				</li>
					
			</ul>
			
			<br><br>
		</c:forEach>
		<br><br>
	<div style="float:right;"><a href="/" class="w3-btn w3-purple">Logout</a></div>
<br>
  <br>
</body>

        </html>