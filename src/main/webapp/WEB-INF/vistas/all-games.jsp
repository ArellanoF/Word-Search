<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Score</title>
<link href="css/allgames.css" rel="stylesheet" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
 
</head>
<body>
	<div class="welcome">
	<div>
		<h1>This are all the scores!</h1>
		<table border="1" cellpadding="5" class="table">
		<thead class="thead-dark">
            <tr>
                <th  scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Date</th>
                <th scope="col">Duration</th>
                <th scope="col">Score</th>
            </tr>
              </thead>
            <% int i = 1; %>
            <c:forEach var="game" items="${scores}">
                <tr>
                	<td scope="row"><%=i++%></td>
                    <td><c:out value="${game.username}" /></td>
                    <td><c:out value="${game.gameDate}" /></td>
                    <td><c:out value="${game.duration}" /></td>
                    <td><c:out value="${game.score}" /></td>
                </tr>
            </c:forEach>
        </table>
        
</table>
	</div>
	<form method="post">
 		<button type="submit" id='newgame' class="btnNewGame">NEW GAME</button>
	</form>
	</div>

</body>
</html>