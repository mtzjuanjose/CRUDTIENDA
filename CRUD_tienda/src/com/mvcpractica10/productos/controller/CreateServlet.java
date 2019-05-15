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
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Funciona"); //Verifico que sí me mande al Servlet
		//Declaramos variables
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/tiendita?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
		//Nos traemos las variables del front.
		String nombreProducto = request.getParameter("txtNombreProducto");
		double precioProducto = Double.parseDouble(request.getParameter("txtPrecioProducto"));
		//int existenciaProducto = Integer.parseInt(request.getParameter("txtExistenciaProducto"));
		String sql = "INSERT INTO productos VALUES ('0', '" + nombreProducto + "', " + precioProducto +")";
		
		//Declaramos objetos
		Connection conn = null;
		Statement stmnt = null;
		int nRegistros = 0;
		//Create
		//Update
		//Read
		//Delet
				
		//Instanciamos driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			//Creamos la consola
			stmnt = conn.createStatement();
			
			//Realizamos el Query
			nRegistros = stmnt.executeUpdate(sql);
			
			if (nRegistros > 0) {
				response.getWriter().append("Registro con éxito.");
			} else {
				response.getWriter().append("No se dio de alta el registro");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			response.getWriter().append("<a href='create.jsp'>Regresar</a>");
			
			try {
				conn.close();
				stmnt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		
		
		
		//Cerramos la conexión
		
		//String sql = "INSERT INTO productos VALUES ('0', '" + nombreProducto + "', " + precioProducto + ", " + existenciaProducto + ")";
		
		
	}
}
