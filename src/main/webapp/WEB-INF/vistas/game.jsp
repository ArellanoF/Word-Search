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
    <script>
	var inicio=0;
	var timeout=0;
 
	function empezarDetener(elemento)
	{
		if(timeout==0)
		{
			// empezar el cronometro
 
			elemento.value="Detener";
 
			// Obtenemos el valor actual
			inicio=vuelta=new Date().getTime();
 
			// iniciamos el proceso
			funcionando();
		}else{
			// detemer el cronometro
 
			elemento.value="Empezar";
			clearTimeout(timeout);
			timeout=0;
		}
	}
 
	function funcionando()
	{
		// obteneos la fecha actual
		var actual = new Date().getTime();
 
		// obtenemos la diferencia entre la fecha actual y la de inicio
		var diff=new Date(actual-inicio);
 
		// mostramos la diferencia entre la fecha actual y la inicial
		var result=LeadingZero(diff.getUTCHours())+":"+LeadingZero(diff.getUTCMinutes())+":"+LeadingZero(diff.getUTCSeconds());
		document.getElementById('crono').innerHTML = result;
 
		// Indicamos que se ejecute esta función nuevamente dentro de 1 segundo
		timeout=setTimeout("funcionando()",1000);
	}
 
	/* Funcion que pone un 0 delante de un valor si es necesario */
	function LeadingZero(Time) {
		return (Time < 10) ? "0" + Time : + Time;
	}
	</script>
 
	<style>
	.crono_wrapper {text-align:center;width:200px;}
	</style>
</head>
<body>

    <div id='juego'></div>
    <div id='Palabras'></div>
    
    <div>
    <a href="/all-games"><button id='solve'>Resolver</button>
    </a>
    </div>
 	<div class="crono_wrapper">
	<h2 id='crono'>00:00:00</h2>
	<input type="button" value="Empezar" onclick="empezarDetener(this);">
	</div>
 	
 	
 	
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