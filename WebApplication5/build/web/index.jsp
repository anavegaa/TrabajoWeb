<%-- 
    Document   : index
    Created on : 15/09/2022, 11:09:00 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DB.Conexion"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <th>Student ID</th>
                    <th><input type="text" name="studentId" value="${student.studentId}"/></th>
                </tr>
                <tr>
                    <th>First Name</th>
                    <th><input type="text" name="firstname" value="${student.firstname}"/></th>
                </tr>
                <tr>
                    <th>Last Name</th>
                    <th><input type="text" name="lastname" value="${student.lastname}"/></th>
                </tr>
                <tr>
                    <th>Year Level</th>
                    <th><input type="text" name="yearLevel" value="${student.yearLevel}"/></th>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add"/>
                        <input type="submit" name="action" value="Edit"/>
                        <input type="submit" name="action" value="Delete"/>
                        <input type="submit" name="action" value="Search"/>
                    </td>
                </tr>
            </table>
        </form>
                <br>
                <table border="1">
                    <th>Student Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Year Level</th>
                    <c:forEach items="${allStudents}" var="stud">
                        <tr>
                            <td>${stud.studentId}</td>
                            <td>${stud.firstname}</td>
                            <td>${stud.lastname}</td>
                            <td>${stud.yearLevel}</td>
                        </tr>
                    </c:forEach>
                </table>
    </body>
</html>
