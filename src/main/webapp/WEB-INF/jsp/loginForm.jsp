<h1>Login Form</h1>
<form action="login" method="post">
	Nombre de usuario: <br/>
	<input type="text" name="usuario"/>
	Contrasena:
	<input type="password" name="contrasena"/>
	<input type="submit" value="login"/>
</form>

<form action="get/cdr" method="get"><!-- cargar atributos a una ruta determinada, metodo 'get' no hay lio, post es para guardar en el servidor -->
	  <label for="numero">numerito:</label>
	  <input type="text" id="number" name="number"><br><br>
	  <input type="submit" value="Submit">
</form>