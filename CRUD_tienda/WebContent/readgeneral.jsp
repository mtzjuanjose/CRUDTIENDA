<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Read General</h2>

<nav class="navbar navbar-default">
<div class ="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="#">MyWebSite :)</a>
</div>
<ul class="nav navbar-nav">
<li class="active"><a href="index.jsp">Home</a></li>
     
      <li><a href="readindividual.jsp">Read Individual</a></li>
      </ul>
</div>
</nav>
      
      <form action="ReadGeneralServlet" method="post">
      <p>
           <input type="submit" value ="Dame los productos">      
      </p>
      </form>
      
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src ="scripts/scrpt.js"></script>
</ul>
</div>
</nav>

</body>
</html>