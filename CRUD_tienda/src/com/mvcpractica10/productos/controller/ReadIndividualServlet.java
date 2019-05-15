package com.mvcpractica10.productos.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadIndividualServlet
 */
@WebServlet("/ReadIndividualServlet")
public class ReadIndividualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Declaramos las variables 
		String idProductoBuscado = request.getParameter("txtIdProductoInd");
		int idProducto =0;
		String nombreProducto="";
		double precioProducto=0.0;
		
		String url="jdbc:mysql://localhost:3306/tiendita?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario="root";
		String password="root";
		String sql = "SELECT * FROM  productos WHERE idproducto ="+idProductoBuscado;
		
		//Declaramos e inicializamos los objetos de conexión
		
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			//Instanciamos dirver
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			//Abrimos la conexion a la base de datos 
			conn=DriverManager.getConnection(url, usuario, password);
			//Creamos la consola
			stmnt=conn.createStatement();
			 rs = stmnt.executeQuery(sql);
			 rs.next();
			 idProducto = rs.getInt("idproducto");
			 nombreProducto=rs.getString(2);
			 precioProducto=rs.getDouble(3);
			 
			 response.getWriter().append("\nId Producto: "+idProducto+", ");
			 response.getWriter().append("\nNombre Producto: "+nombreProducto+", ");
			 response.getWriter().append("\nId Producto: "+precioProducto);
			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
			try {
				rs.close();
				stmnt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
  }		
 }
}