package com.mvcpractica10.productos.model;

public class Productos {
	private String nombreProducto;
	private double precioProducto;
	private int idProducto;
	
	public Productos()
	{
		
	}
	
	public Productos (String nombreProducto, double precioProducto, int idProducto) {
		this.nombreProducto=nombreProducto;
		this.precioProducto=precioProducto;
		this.idProducto=idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	

}
