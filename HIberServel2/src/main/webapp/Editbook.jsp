<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 25-10-2023
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.hiberservel2.secondEntity, org.hibernate.Session, org.hibernate.SessionFactory, org.hibernate.cfg.Configuration" %>
<html>
<head>
    <title>Edit Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form {
            text-align: center;
        }

        label {
            display: block;
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Edit Book</h1>
    <form action="UpdateBook" method="post">
        <%
            // Get the book ID from the request
            int bookId = Integer.parseInt(request.getParameter("bookId"));

            // Initialize Hibernate configuration
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf = cfg.buildSessionFactory();

            // Open a Hibernate session
            Session se = sf.openSession();

            // Retrieve the book with the specified ID
            secondEntity book = se.get(secondEntity.class, bookId);
        %>
        <input type="hidden" name="bookId" value="<%= book.getId() %>">
        <label for="bookName">Book Name:</label>
        <input type="text" id="bookName" name="bookName" value="<%= book.getBookName() %>" required><br><br>

        <label for="authorName">Author Name:</label>
        <input type="text" id="authorName" name="authorName" value="<%= book.getBookAuthor() %>" required><br><br>

        <button type="submit">Save Changes</button>
        <%
            // Close the Hibernate session and session factory
            se.close();
            sf.close();
        %>
    </form>
</div>
</body>
</html>
