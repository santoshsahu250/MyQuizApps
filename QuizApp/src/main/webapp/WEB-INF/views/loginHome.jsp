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
        <br>
        <br>
        <div style="width: 100% ; padding-left: 25%;">
            <div class="w3-card-4" style="width: 50%">
                <div class="w3-container w3-deep-purple">
                    <h2>Login</h2>
                </div>
                <form action="login" method="post"  class="w3-container">
                    <label class="w3-large">Student Name</label>
                    <input id="name" name="name" class="w3-input w3-large" style=" text-align:center;">
                    <!-- 
                    <label>Roll No</label>
                    <input id="roll" name="roll" class="w3-input" style=" text-align:center;">
                    <label>Class</label>
                    <input id="clazz" name="clazz" class="w3-input" style=" text-align:center;">
                     -->
                    <label class="w3-large">School</label>
                    <br>
                    <select id="school" name="school" class="w3-input w3-large" style=" text-align:center;">
                    <c:forEach items="${schoolList}" var="element"> 
                    
                        <option class="w3-large" value="${element}">${element}</option>
                  
                    </c:forEach>
                    </select>
                   
                    <label class="w3-large" >Password</label>
                    <input id="pwd" name="pwd" type="password" class="w3-input w3-large" style=" text-align:center;">
                    <br>
                    <input type="submit" value="Submit" class="w3-button w3-indigo" style="float: right;">
					<br><br> <label class="w3-red w3-large">${loginError}</label><br><br>
                </form>
            </div>
        </div>
    </body>

    </html>