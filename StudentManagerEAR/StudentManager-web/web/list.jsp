<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Manager - List</title>
    </head>
    <body>
        <h2>Student Manager</h2>
        
        <table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse;">
            <thead style="background-color: #f2f2f2;">
                <tr>
                    <th>Roll number</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="s" items="${studentList}">
                    <tr>
                        <td>${s.rollnumber}</td>
                        <td>${s.name}</td>
                        <td>${s.email}</td>
                        <td>${s.age}</td>
                        <td>
                            <a href="StudentServlet?action=delete&rollnumber=${s.rollnumber}" 
                               onclick="return confirm('Are you sure you want to delete this student?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href="create.jsp">Add Student</a><br/>
        <a href="index.jsp">Index</a>
    </body>
</html>
