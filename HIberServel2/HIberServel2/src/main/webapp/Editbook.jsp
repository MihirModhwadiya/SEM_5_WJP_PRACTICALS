<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.hiberservel2.secondEntity, org.hibernate.Session, org.hibernate.SessionFactory, org.hibernate.cfg.Configuration" %>
<html>
<head>
    <title>Add Library Entry</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: url("back.jpg") no-repeat center center fixed;
            background-size: cover;
        }

        /* Sidebar Styles */
        .sidebar {
            width: 250px;
            height: 100%;
            position: fixed;
            top: 0;
            left: 0; /* Changed from -250px to show the sidebar by default */
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

        /* Form Styles */
        .form-container {
            width: 500px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.5); /* Set opacity to 0.5 for transparency */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-container form {
            padding: 10px;
        }

        .form-container .row {
            margin-bottom: 10px;
        }

        /* Additional Styles for the Edit Book Page */
        h1 {
            color: #2196F3;
            font-size: 36px;
            text-transform: uppercase;
            font-weight: bold;
            letter-spacing: 2px;
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

        .row.center-align {
            text-align: center;
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
<!-- Sidebar Button -->


<!-- Page Content - Form Container -->
<div class="form-container">
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
        <div class="row">
            <input type="hidden" name="bookId" value="<%= book.getId() %>">
            <label for="bookName">Book Name:</label>
            <input type="text" id="bookName" name="bookName" value="<%= book.getBookName() %>" required>
        </div>
        <div class="row">
            <label for="authorName">Author Name:</label>
            <input type="text" id="authorName" name="authorName" value="<%= book.getBookAuthor() %>" required>
        </div>
        <div class="row center-align">
            <button type="submit">Save Changes</button>
        </div>
    </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>


</body>
</html>
