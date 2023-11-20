<%@ page import="com.example.pra3.StudentEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>std</title>
</head>
<body>

<center><h1>Student List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Branch</th>
        </tr>
        <%
            List<StudentEntity> studentInfos = (List<StudentEntity>) request.getAttribute("stdinfo");
            if (studentInfos != null) {
                for (StudentEntity student : studentInfos) {
        %>
        <tr>
            <td><%= student.getStudentId() %>
            </td>
            <td><%= student.getStudentName() %>
            </td>
            <td><%= student.getBranch() %>
            </td>
        </tr>
        <% }
        } else {

        }%>
    </table>
</center>
</body>
</html>
