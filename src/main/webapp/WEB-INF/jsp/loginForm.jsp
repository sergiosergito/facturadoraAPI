<h1>Login Form</h1>
<!--  
<form action="login" method="post">
	Nombre de usuario: <br/>
	<input type="text" name="usuario"/>
	Contrasena:
	<input type="password" name="contrasena"/>
	<input type="submit" value="login"/>
</form>
-->

<form action="get/cdr" method="get"><!-- cargar atributos a una ruta determinada, metodo 'get' no hay lio, post es para guardar en el servidor -->
	  <label for="numero">Ingrese Numero de Telefono movil:</label>
	  <input type="text" id="number" name="number"><br><br>
	  <!--   <input type="month" id="month" name="month"> -->
	  <!-- 
	  <select name="months" id="cars">
	    <option value="1">	Enero	</option>
	    <option value="2">	Febrero	</option>
	    <option value="3">	Marzo	</option>
	    <option value="4">	Abril	</option>
	    <option value="5">	Mayo	</option>
	    <option value="6">	Junio	</option>
	    <option value="7">	Julio	</option>
	    <option value="8">	Agosto	</option>
	    <option value="9">	Septiembre</option>
	    <option value="10">	Octubre	</option>
	    <option value="11">	Noviembre</option>
	    <option value="12">	Diciembre</option>
	  </select>
	   -->
	  <input type="submit" value="Submit">
</form>