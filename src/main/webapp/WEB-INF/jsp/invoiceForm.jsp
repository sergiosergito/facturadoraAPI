<head>
  <title>Formulario Facturadora API</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"> -->
  <style>
  	header {
      background-color: #666;
      padding: 10px;
      text-align: center;
      font-size: 20px;
      color: white;
    }
    .button {
      background-color: #4CAF50; /* Green */
      border: none;
      color: white;
      padding: 15px 32px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: 4px 2px;
      cursor: pointer;
    }
	    input[type=text], select {
	  width: 50%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	
	input[type=submit] {
	  width: 100%;
	  background-color: #4CAF50;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}
	
	input[type=submit]:hover {
	  background-color: #45a049;
	}
	
	div {
	  border-radius: 5px;
	  background-color: #f2f2f2;
	  padding: 20px;
	}
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  
</head>
<body>
	<header>
	  	<h2>Formulario para facturar</h2>
	</header>
	<form action="/getcdr" method="get" style="text-align:center;">
		  <br></br>
		  <label for="persistencia">Seleccione repositorio: </label>
		  <br></br>
		  <select class="form-control" name="persistence" id="persistence">
		    <option value="sql">	SQL	</option>
		    <option value="archivo">	Archivos	</option>
		  </select>
		  <br></br>
		  <label for="numero">Ingrese Numero de Telefono movil: </label>
		  <br></br>
		  <input type="number" id="number" name="number" required><br><br>
		  <label for="mes">Seleccione Mes: </label>
		  <br></br>
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
		  <br></br>
		  <input type="submit" value="Facturar">
	</form>
	<li>${mensaje}</li>
</body>
