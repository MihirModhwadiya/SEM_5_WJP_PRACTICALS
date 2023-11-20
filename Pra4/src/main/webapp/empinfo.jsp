<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Emp info</title>
</head>
<body>

<h1>Employee info</h1>
<p>Total number of employees: <%=request.getAttribute("employeeCount") %>
</p>
<p>Maximum salary: <%=request.getAttribute("maxSalary") %>
</p>
<p>Minimum salary: <%=request.getAttribute("minSalary") %>
</p>
<p>Total salary: <%=request.getAttribute("totalSalary") %>
</p>
<p>Average salary: <%=request.getAttribute("averageSalary") %>
</p>

</body>
</html>
