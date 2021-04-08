<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>Sopa de letras</title>
  
    <link rel="stylesheet" type="text/css" href="/css/wordfind.css">
    <script language="javascript" type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
    <script type="text/javascript" src="/wordfind/wordfind.js"></script> 
    <script type="text/javascript" src="/wordfind/wordfindgame.js"></script> 
</head>
<body>

    <div id='juego'></div>
    <div id='Palabras'></div>
    
    <div><button id='solve'>Resolver</button></div>
 	
 	
 	
 	
    <script>
    var words = [];
   	var word1 = "${palabras[0]}";
   	if (word1 != "")
    {
   		words.push(word1);
    }
   	var word2 = "${palabras[1]}";
   	if (word2 != "")
    {
   		words.push(word2);
    }
   	var word3 = "${palabras[2]}";
   	if (word3 != "")
    {
   		words.push(word3);
    }
   	var word4 = "${palabras[3]}";
   	if (word4 != "")
    {
   		words.push(word4);
    }
   	var word5 = "${palabras[4]}";
   	if (word5 != "")
    {
   		words.push(word5);
    }
    var gamePuzzle = wordfindgame.create(words, '#juego', '#Palabras'); 
        
    var puzzle = wordfind.newPuzzle(words,{height: 18, width:18, fillBlanks: false});
    wordfind.print(puzzle);   
        
    $('#solve').click( function() {wordfindgame.solve(gamePuzzle, words);});
        
    </script>
    
</body>
</html>