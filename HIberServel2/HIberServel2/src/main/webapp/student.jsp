<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Book</title>
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
            background: url("back.jpg") no-repeat center center fixed;
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
        .form-container {
            width: 500px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.7); /* Adjust the alpha (0.7) for transparency */
            border-radius: 5px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            text-align: center; /* Center the form */
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin: 0 auto;
        }
        .form-container form {
            padding: 10px;
        }

        .form-container .row {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<!-- Sidebar Button -->
<span class="openbtn" onclick="toggleNav()">&#9776;</span>

<!-- Sidebar -->
<div id="mySidebar" class="sidebar">
    <a href="#" onclick="toggleNav()"><i class="fas fa-times"></i></a>
    <a href="student.jsp">Student-Section</a>
    <a href="second.jsp">Insert Book</a>
    <a href="books.jsp">Show Books</a>
    <a href="studentshow.jsp">Show Student</a>
</div>

<div class="container" style="align: center">
    <div class="form-container">
        <form action="studentMain" method="post">
            <h1 class="center-align" style="color: #2196F3; font-size: 36px; text-transform: uppercase; font-weight: bold; letter-spacing: 2px;">Register book</h1>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="studentName" name="studentName" class="validate" required>
                    <label for="studentName">Student Name</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="number" id="bookName" name="bookId" class="validate" required>
                    <label for="bookName">Book Id</label>
                </div>
            </div>
<%--            <div class="row">--%>
<%--                <div class="input-field col s12">--%>
<%--                    <input type="date" id="issueDate" name="issueDate" class="validate" required>--%>
<%--                    <label for="issueDate">Issue Date</label>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="row">--%>
<%--                <div class="input-field col s12">--%>
<%--                    <input type="date" id="returnDate" name="returnDate" class="validate" required>--%>
<%--                    <label for="returnDate">Return Date</label>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="row center-align">
                <button class="btn waves-effect waves-light blue" type="submit">Insert</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script>
    M.AutoInit(); // Initialize Materialize tooltips
</script>

<script>
    function toggleNav() {
        var sidebar = document.getElementById("mySidebar");

        if (sidebar.style.left === "0px") {
            sidebar.style.left = "-250px";
        } else {
            sidebar.style.left = "0";
        }
    }
</script>
</body>
</html>
