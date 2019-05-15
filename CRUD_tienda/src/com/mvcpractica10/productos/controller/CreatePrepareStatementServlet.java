package com.mvcpractica10.productos.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcpractica10.productos.model.Productos;

/**
 * Servlet implementation class CreatePrepareStatement
 */
@WebServlet("/CreatePrepareStatementServlet")
public class CreatePrepareStatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Declarar variable
		String user = "root";
		String password = "root";
		String urlServidor = "jdbc:mysql://localhost:3306/tiendita?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String sentenciasql= "insert into productos values('0',?,?)"; 	
		
		//declarar objestos
		Productos miProducto =new Productos();
		miProducto.setNombreProducto(request.getParameter("txtNombreProducto"));
		miProducto.setPrecioProducto(Double.parseDouble(request.getParameter("txtPrecioProducto")));
		
		
		Connection conn=null;
		PreparedStatement pstmnt=null;
		int nRegistros=0;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
		conn = DriverManager.getConnection(urlServidor, user, password);
		pstmnt = conn.prepareStatement(sentenciasql);
		pstmnt.setString(1, miProducto.getNombreProducto());
		pstmnt.setDouble(2, miProducto.getPrecioProducto());
		nRegistros = pstmnt.executeUpdate();

		if(nRegistros>0){
			response.getWriter().append("Registro Exitoso");
		}else {
			response.getWriter().append("Registro fallido");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			response.getWriter().append("<a href='CreatePrepareStatement.jsp'>Regresar </a>");
			
			try {
				conn.close();
				pstmnt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
