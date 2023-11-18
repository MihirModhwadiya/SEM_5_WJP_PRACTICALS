<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 15-10-2023
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Library Entry</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
        }

        .container {
            max-width: 600px; /* Adjusted the maximum width */
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc; /* Added a border */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            text-align: center;
        }

        label {
            display: block;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="center-align">Add Book</h1>
    <form action="secondMain" method="post">
        <div class="row">
            <div class="input-field col s12">
                <input type="text" id="bookName" name="bookName" class="validate" required>
                <label for="bookName">Book Name</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input type="text" id="authorName" name="authorName" class="validate" required>
                <label for="authorName">Author Name</label>
            </div>
        </div>
        <div class="row center-align">
            <button class="btn waves-effect waves-light blue" type="submit">Insert</button>
        </div>
        <div class="row center-align">
            <a href="books.jsp" class="btn waves-effect waves-light">All Books</a>
        </div>
    </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
