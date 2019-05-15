package com.mvcpractica10.productos.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransationsServlet
 */
@WebServlet("/TransationsServlet")
public class TransationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   

	    Properties props = new Properties ();
		//declarar el nombre del achivo de los properties 
		String nombreArchivo = "config.properties";
		//intanciar el Stream 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nombreArchivo);
		
		if (inputStream != null) {
			props.load(inputStream);
		} else 
		{
			throw new FileNotFoundException("Property / file '"+nombreArchivo+"' No se encontró el Classpath");
		}
		
		String usuario = props.getProperty("user");
		String pass = props.getProperty("password");
		String urlServidor =props.getProperty("urlServidor");
		
		
		String aProducto1 = props.getProperty("altaProductos1");
		String aProducto2 = props.getProperty("altaProductos2");
		String aProducto3 = props.getProperty("altaProductos3");
		String aProducto4 = props.getProperty("altaProductos4");
		String aProducto5 = props.getProperty("altaProductos5");
		
		//DEclaramos objetos 
		Connection conn = null;
		PreparedStatement pstmnt = null;
	    int nRegistros =0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(urlServidor, usuario, pass);
			conn.setAutoCommit(false);
			
			//Producto 1
			pstmnt = conn.prepareStatement(aProducto1);
			pstmnt.setString(1, "pera");
			pstmnt.setDouble(2, 24.50);
			pstmnt.executeUpdate();
			pstmnt.close();
			
			//Producto 2
			pstmnt = conn.prepareStatement(aProducto2);
			pstmnt.setString(1, "jicama");
			pstmnt.setDouble(2, 4.50);
			pstmnt.executeUpdate();
			
			//Producto 3
			pstmnt = conn.prepareStatement(aProducto3);
			pstmnt.setString(1, "mango");
			pstmnt.setDouble(2, 12.50);
			pstmnt.executeUpdate();
			
			//Producto 4
			pstmnt = conn.prepareStatement(aProducto4);
			pstmnt.setString(1, "manzana");
			pstmnt.setDouble(2, 34.50);
			pstmnt.executeUpdate();
			
			//Producto 5
			pstmnt = conn.prepareStatement(aProducto5);
			pstmnt.setString(1, "ciruela");
			pstmnt.setDouble(2, 17.50);
			pstmnt.executeUpdate();	
			conn.commit();
			if(nRegistros>0){
				response.getWriter().append("Registro Exitoso");
			}else {
				response.getWriter().append("Registro fallido");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();	
		
		try {
			conn.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		}
		finally {
			//Cerramos conexiones para ponerlos en el garbage collector
			try {
		
				pstmnt.close();
				conn.close();		
			} 
			catch (SQLException ex) {
				
				ex.printStackTrace();
			}
		}
	}
}	
