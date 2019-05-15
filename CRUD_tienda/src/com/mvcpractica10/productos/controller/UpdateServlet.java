package com.mvcpractica10.productos.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Funciona"); //Verifico que sí me mande al Servlet
				//Declaramos variables
				String user = "root";
				String password = "root";
				String url = "jdbc:mysql://localhost:3306/tiendita?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				
				//Nos traemos las variables del front.
				int idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));
				double precioNuevo = Double.parseDouble(request.getParameter("txtPrecioProductoN"));
				
				String sql = "UPDATE productos SET precioproducto = '"+precioNuevo+"' WHERE idproducto =  '" +idProducto+"'";
				
				//Declaramos objetos
				Connection conn = null;
				Statement stmnt = null;
				double nUpdate =0.00;
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
					nUpdate = stmnt.executeUpdate(sql);
					
					if (nUpdate == precioNuevo ) {
						response.getWriter().append("Se actualizó el producto con éxito.");
					} else {
						response.getWriter().append("No se actualizó el producto");
					}
					
				} catch (Exception e) {
					
					e.printStackTrace();
				} finally {
					response.getWriter().append("<a href='updatejsp.jsp'>Regresar</a>");
					
					try {
						
						stmnt.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}

					
	}
}
