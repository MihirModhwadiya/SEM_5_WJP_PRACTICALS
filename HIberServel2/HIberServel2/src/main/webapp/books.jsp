<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 25-10-2023
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.example.hiberservel2.secondEntity, org.hibernate.Session, org.hibernate.SessionFactory, org.hibernate.cfg.Configuration" %>
<html>
<head>
    <title>Books List</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: url(back.jpg) no-repeat center center fixed;
            background-size: cover;
        }

        .sidebar {
            width: 250px;
            height: 100%;
            position: fixed;
            top: 0;
            left: -250px;
            overflow-y: hidden;
            transition: 0.3s;
            padding-top: 60px;
            background-color: rgba(51, 51, 51, 0.8);
        }

        .sidebar a {
            padding: 15px 25px;
            text-decoration: none;
            font-size: 20px;
            color: #f1f1f1;
            display: block;
            transition: 0.3s;
        }

        .sidebar a:hover {
            background-color: #555;
        }

        .openbtn {
            font-size: 30px;
            cursor: pointer;
            position: fixed;
            margin: 20px;
            top: 0;
            left: 0;
            background-color: #333;
            color: white;
            border: none;
            border-radius: 0;
            padding: 10px 20px;
        }

        .openbtn:hover {
            background-color: #555;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.5); /* Increased alpha value for more transparency */
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #422793;
            color: #fff;
        }

        tr:nth-child(odd) {
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            color: white;
        }

        .remove-icon {
            color: red;
            cursor: pointer;
        }

        .remove-icon1 {
            color: blue;
            cursor: pointer;
        }
    </style>
</head>
<body>
<span class="openbtn" onclick="toggleNav()">&#9776;</span>

<!-- Sidebar -->
<div id="mySidebar" class="sidebar">
    <a href="#" onclick="toggleNav()"><i class="fas fa-times"></i></a>
    <a href="student.jsp">Student-Section</a>
    <a href="second.jsp">Insert Book</a>
    <a href="books.jsp">Show Books</a>
    <a href="studentshow.jsp">Show Student</a>
</div>

<div class="container">
    <h1>Book List</h1>
    <table class="responsive-table striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Book Name</th>
            <th>Author Name</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <%
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf = cfg.buildSessionFactory();
            Session se = sf.openSession();

            List<secondEntity> booksList = se.createQuery("FROM secondEntity").list();

            for (secondEntity book : booksList) {
        %>
        <tr>
            <td><%= book.getId() %></td>
            <td><%= book.getBookName() %></td>
            <td><%= book.getBookAuthor() %></td>
            <td>
                <form method="post" action="DeleteBook">
                    <input type="hidden" name="bookId" value="<%= book.getId() %>">
                    <button type="submit" class="remove-icon tooltipped" data-position="top" data-tooltip="Delete"><i class="fas fa-trash"></i></button>
                </form>
            </td>
            <td>
                <a href="Editbook.jsp?bookId=<%= book.getId() %>" class="remove-icon1 tooltipped" data-position="top" data-tooltip="Edit">
                    <i class="fas fa-pencil-alt"></i>
                </a>
            </td>
        </tr>
        <%
            }

            // Close the Hibernate session and session factory
            se.close();
            sf.close();
        %>
        </tbody>
    </table>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script>
    M.AutoInit(); // Initialize Materialize tooltips
</script>

<script>
    function toggleNav() {
        var sidebar = document.getElementById("mySidebar");

        if (sidebar.style.left === "0px") {
            sidebar.style.left = "-250px"; // Hide sidebar
        } else {
            sidebar.style.left = "0"; // Show sidebar
        }
    }
</script>
</body>
</html>
