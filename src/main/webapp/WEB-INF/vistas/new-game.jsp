<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Game</title>
<link href="css/newgame.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="welcome">
	<div>
		<h1>Create a new Game!</h1>
	</div>
	<div>
		<form id="newgame" action="new-game" method="post">
			<div class="username">
				<label>Username: </label>
				<input name = "user"/>
			</div>
		<div class="words">
			<label>Words: </label>
			<input type="text" name ="word1"/>
			<input type="text" name ="word2"/>
			<input type="text" name ="word3"/>
			<input type="text" name ="word4"/>
			<input type="text" name ="word5"/>
			<button type="submit">Create</button>
			<button><a href="/game">Play</a></button>
		</div>	
		</form>
	</div>
	
	</div>
</body>
</html>