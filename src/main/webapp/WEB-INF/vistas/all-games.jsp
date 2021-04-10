<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Score</title>
<link href="css/newgame.css" rel="stylesheet" type="text/css">
 
</head>
<body>
	<div class="welcome">
	<div>
		<h1>This are all the scores!</h1>
		<table border="1" cellpadding="5">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Date</th>
                <th>Duration</th>
                <th>Score</th>
            </tr>
            <% int i = 1; %>
            <c:forEach var="game" items="${scores}">
                <tr>
                	<td><%=i++%></td>
                    <td><c:out value="${game.username}" /></td>
                    <td><c:out value="${game.gameDate}" /></td>
                    <td><c:out value="${game.duration}" /></td>
                    <td><c:out value="${game.score}" /></td>
                </tr>
            </c:forEach>
        </table>
	</div>
	<form method="post">
 		<button type="submit" id='newgame'>NEW GAME</button>
	</form>
	</div>

</body>
</html>