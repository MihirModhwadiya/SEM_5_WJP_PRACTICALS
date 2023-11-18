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
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 100%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        tr:nth-child(odd) {
            background-color: #f2f2f2;
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
<h1 class="center-align">Books List</h1>

<div class="container">
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
            // Initialize Hibernate configuration
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf = cfg.buildSessionFactory();

            // Open a Hibernate session
            Session se = sf.openSession();

            // Retrieve data from the database
            List<secondEntity> booksList = se.createQuery("FROM secondEntity").list();

            // Loop through the list and display data in the table
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
</body>
</html>
k