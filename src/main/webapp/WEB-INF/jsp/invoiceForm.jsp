<head>
  <title>Formulario Facturadora API</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<form action="get/cdr" method="get"><!-- cargar atributos a una ruta determinada, metodo 'get' no hay lio, post es para guardar en el servidor -->
	  <h1>Formulario para facturar</h1>
	  <label for="numero">Ingrese Número de Teléfono móvil: </label>
	  <input type="text" id="number" name="number"><br><br>
	  <select name="months" id="months">
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
	   
	  <input type="submit" value="Submit">
</form>