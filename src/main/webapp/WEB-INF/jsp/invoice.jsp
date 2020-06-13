<!DOCTYPE html>
<html lang="en">
<head>
<title>Facturadora API</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
    * {
      box-sizing: border-box;
    }

    body {
      font-family: Arial, Helvetica, sans-serif;
    }

        .container {
      width: 800px;
    }

    

    /* Style the header */
    header {
      background-color: #666;
      padding: 10px;
      text-align: right;
      font-size: 20px;
      color: white;
    }

    /* Create two columns/boxes that floats next to each other */
    nav {
      float: left;
      width: 30%;
      height: 300px; /* only for demonstration, should be removed */
      /*background: #ccc;*/
      padding: 20px;
    }

    /* Style the list inside the menu */
    nav ul {
      list-style-type: none;
      padding: 0;
    }

    article {
      float: left;
      padding: 20px;
      width: 70%;
      background-color: #f1f1f1;
      height: 300px; /* only for demonstration, should be removed */
    }

    /* Clear floats after the columns */
    section:after {
      content: "";
      display: table;
      clear: both;
    }

    /* Style the footer */
    footer {
      background-color: #777;
      padding: 10px;
      text-align: center;
      color: white;
    }

    /* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
    @media (max-width:600px) {
      nav, article {
        width: 100%;
        height: auto;
      }
    }
</style>
</head>
<body>
  <header>
      <h2>Facturadora API</h2>
      <form action="javascript:window.print()">
          <input type="submit" value="Imprimir" />
      </form>

  </header>

  
  <section>
    <nav>
        <strong>Dream Team</strong><br>
        Universidad Catolica, Cochabamba<br>
        Bolivia.<br>
      </nav>
      <nav>
        Web: <a href="http://localhost:4567/">www.tariricadora.bo</a><br>
        E-mail: <a href="mailto:https://mail.ucbcba.edu.bo/">https://mail.ucbcba.edu.bo/</a><br>
        Tel: +444-555-666-777<br>
        Facebook: @dreamteambo
      </nav>
  </section>

  

  <section>
    <nav>
      <ul>
        <strong>Facturar a</strong><br>
        <li>${nombreUsuario}</li>
        <li>${nombrePlan}</li>
        <li>${numeroLinea}</li>
        <li>Fecha: date</li>
        <li>Factura:  0001</a></li>
        <li>Vence: 31-12-2020</a></li>
      </ul>
    </nav>
    
    <article>
      <h1>London</h1>
      <p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
      <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
    </article>
  </section>

  <footer>
    <p>Footer</p>
  </footer>

</body>
</html>