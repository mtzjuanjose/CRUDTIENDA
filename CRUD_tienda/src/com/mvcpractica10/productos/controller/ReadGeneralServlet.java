package com.mvcpractica10.productos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadGeneralServlet
 */
@WebServlet("/ReadGeneralServlet")
public class ReadGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html charset='UTF-8'");
		PrintWriter salida = response.getWriter();
		
		//DEclaramos e iniicalizamos las credenciales de acceso
		String url="jdbc:mysql://localhost:3306/tiendita?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario="root";
		String password="root";
	
		
		//Declaramos e inicializamos los objetos de conexión
		
		Connection conn=null;
		Statement stmnt=null;
		ResultSet rs=null;
		
		try {
			//Se instancia el comando
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    
			conn=DriverManager.getConnection(url, usuario,password);
			//Se apuntan el objeto statement que nos sirve para ejecutar comandos en la base de datos (se crea la consola de comandos que apuntan a esa conexion)
			 stmnt=conn.createStatement();
			 
			 rs = stmnt.executeQuery("SELECT * FROM PRODUCTOS");
			while(rs.next()) 
			{
			 salida.append("Id Producto: "+rs.getInt("idproducto"));	
			 salida.append("</br>");
			 salida.append("Nombre Producto: "+rs.getString("nombreproducto"));
			 salida.append("</br>");
			 salida.append("Precio Producto: "+rs.getDouble("precioproducto"));
			 salida.append("</br>");
			 salida.append("</br>");
			}
			
		} catch (Exception e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  } finally 
		    {
			
			try 
			{	
				//Cerramos la coneccion y colocamos los objetos a disposicion del garbage collector 
				rs.close();
				stmnt.close();
				conn.close();
			} catch (SQLException e) 
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			
		    }
        salida.close();
	
 } 
}