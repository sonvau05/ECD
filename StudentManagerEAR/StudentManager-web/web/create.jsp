<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Manage - Create</title>
    </head>
    <body>
        <h2>Student Manage</h2>
        <form action="StudentServlet" method="POST">
            <input type="hidden" name="action" value="add"/>
            
            <table cellpadding="5">
                <tr>
                    <td>Rollnumber</td>
                    <td><input type="text" name="rollnumber" required /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" required /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" required /></td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="number" name="age" min="1" required /></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Add" />
                        <input type="reset" value="Clear" />
                    </td>
                </tr>
            </table>
        </form>
        <br/>
        <a href="StudentServlet?action=list">List of Student</a><br/>
        <a href="index.jsp">Index</a>
    </body>
</html>
