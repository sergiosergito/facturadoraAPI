<html>
	<body>
		<H1>Hola Index.jsp</H1>
		<form action="/login" method="GET">
			<input type="submit" value="ir a Login"/>
		</form>
		<form action="get/cdr" method="get"><!-- cargar atributos a una ruta determinada, metodo 'get' no hay lio, post es para guardar en el servidor -->
		  <label for="numero">numerito:</label>
		  <input type="text" id="number" name="number"><br><br>
		  <input type="submit" value="Submit">
		</form>
		<a href="/login">Ir a Pagina Login</a>
		<br/>Este es un cambio
	</body>
</html>