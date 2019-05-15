<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/style.css">
   
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   
</head>
<body>
<h2>Update</h2>


   <nav class="navbar navbar-default">
    <div class ="container-fluid">
     <div class="navbar-header">
      <a class="navbar-brand" href="#">MyWebSite :)</a>
      </div>
     <ul class="nav navbar-nav">
    <li class="active"><a href="index.jsp">Home</a></li>
      
  </ul>
 </div>
</nav>


  <form action="UpdateServlet" method="post">
    <p>
      <label for="txtIdProducto">Inserte el Id del producto a corregir:</label>
      <input type="text" id="txtIdProducto" name= "txtIdProducto" required>
    </p>
   
    <p>
      <label for="txtPrecioProductoN">Inserte el nuevo precio del producto:</label>
      <input type="text" id="txtPrecioProductoN" name= "txtPrecioProductoN" required>
    </p>
  </form>
  
    <p>
      <input type="submit" value="Actualizar Precio Producto">
    </p>


 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src ="scripts/scrpt.js"></script>
</body>
</html>