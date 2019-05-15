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

import com.mvcpractica10.productos.model.Productos;


@WebServlet("/CreatePrepareStatementPropServlet")
public class CreatePrepareStatementPropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String user = "root";
		String password = "root";
        
		String url = "jdbc:mysql://localhost:3306/tiendita?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		*/
		
		
		//Obtener datos del archivos de propiedades 
		String result ="";
		//crear el njeto porperties
		Properties props = new Properties ();
		//declarar el nombre del achivo de los properties 
		String nombreArchivo = "config.properties";
		//intanciar el Stream 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nombreArchivo);
		
		if (inputStream != null) {
			props.load(inputStream);
		} else {
			throw new FileNotFoundException("Property / file '"+nombreArchivo+"' No se encontró el Classpath");
		}

		
		Productos miProducto = new Productos();
		miProducto.setNombreProducto (request.getParameter("txtNombreProducto"));
		miProducto.setPrecioProducto(Double.parseDouble(request.getParameter("txtPrecioProducto")));
		
		String usuario = props.getProperty("user");
		String pass = props.getProperty("password");
		String sentenciaSQL = props.getProperty("sentenciaSQL");
		String urlServidor =props.getProperty("urlServidor");
		
		Connection conn = null;
		PreparedStatement pstmnt = null;
		int nRegistros = 0;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
			conn = DriverManager.getConnection(urlServidor, usuario, pass);
			pstmnt = conn.prepareStatement(sentenciaSQL);
			
			//pstmnt.setInt(1, 0);
			pstmnt.setString(1, miProducto.getNombreProducto());
			pstmnt.setDouble(2, miProducto.getPrecioProducto());
			
			nRegistros = pstmnt.executeUpdate();
			if (nRegistros >0) { 
				response.getWriter().append("Registro añadido con éxito");
				response.getWriter().append("<a href='CreatePrepareStatementProp.jsp'>Regresar</a>");
			} else {
				response.getWriter().append("Error en el regitro");
				response.getWriter().append("<a href='CreatePrepareStatementProp.jsp'>Regresar</a>");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Cerramos conexiones para ponerlos en el garbage collector
			try {
		
				pstmnt.close();
				conn.close();		
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}	
		//obtener las propiedades 
	/*response.getWriter().append("Valor del parámetro urlServido:" +props.getProperty("urlServidor"));
	response.getWriter().append("<\br>");
	
	response.getWriter().append("Valor del parámetro user: " +props.getProperty("user"));
	response.getWriter().append("<\br>");
	
	response.getWriter().append("Valor del parámetro Password: " +props.getProperty("password"));
	response.getWriter().append("<\br>");
	
	response.getWriter().append("Valor del parámetro sentenciaSQL: " +props.getProperty("sentenciaSQL"));
	response.getWriter().append("<\br>");  */
	
  } 
}