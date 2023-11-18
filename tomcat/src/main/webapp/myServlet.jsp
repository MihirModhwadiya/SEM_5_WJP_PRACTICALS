<!--<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="myServlet" method="GET">
			<label>
				<h3>Enter your name: </h3>
			</label>
			<input type="text" name="user" />
			<button type="submit">Submit</button>
		</form>
	</center>
</body>
</html>-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div></div>
    <div>
        <h2>Registration</h2>
        <form action="myServlet" method="POST" id="registration-form">
            <div>
                <label for="name">Full Name</label>
                <input type="text" id="name" name="name" placeholder="Enter your full name..." required>
            </div>
            <div>
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter your email..." required>
            </div>
            <div>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password..." required>
            </div>
            <div>
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password..." required>
            </div>
            <p id="error-message"></p>
            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
