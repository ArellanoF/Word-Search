<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-store,no-cache,must-revalidate"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Expires" content="-1"> 
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
	<div>
		<h1>BACK-EE-NDS</h1>
		 <h2>Autentication Web App</h2>
		<h4>Please enter your credentials!</h4>
		

		<form method="POST" action="/login">
			<table>
				<tr><td>User Name: </td><td><input type="text" name="username"/></td></tr>
				<tr><td>Password: </td><td><input type="password" name="password"/></td></tr>
				<tr><td></td><td><input type="submit" name="buttonSubmit" value="Login"/></td></tr>
			</table>
		</form>
		<div class="error">
			<%
				String error = request.getParameter("error");
				if(error != null){
					if(error.equals("true")){
						out.print("Bad credentials, please try again!");
					}
				}
			%>
		</div>
	</div>

</body>
</html>