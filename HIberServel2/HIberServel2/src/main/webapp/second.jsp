<!DOCTYPE html>
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

<!-- Page Content - Form Container -->
<div class="form-container">
    <h1 class="center-align" style="color: #2196F3; font-size: 36px; text-transform: uppercase; font-weight: bold; letter-spacing: 2px;">Add Book</h1>

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
            <button class="btn waves-effect waves-light blue" type="submit" >Insert</button>
        </div>
<%--        <div class="row center-align">--%>
<%--            <a href="books.jsp" class="btn waves-effect waves-light">All Books</a>--%>
<%--        </div>--%>
    </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<script>
    // let btn = document.getElementById("insert_data");
    // let bkname = document.getElementById("bookName");
    // let bkauthor = document.getElementById("authorName");

    // btn.addEventListener("click", (e) => {
    //     e.preventDefault();
    //     // if (bkname.value.trim() === '' || bkauthor.value.trim() === '') {
    //     //     alert("Both Book Name and Author Name are required fields...!");
    //     // }
    //     // else {
    //         alert("Book added successfully....");
    //     // }
    // });

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
