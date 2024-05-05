package ar.edu.unju.fi.ejercicio05.model;


public class Producto {
	public enum Origen {
		BRASIL,ARGENTINA,CHINA,URUGUAY;
	}
	public enum Categoria{
		TELEFONIA,INFORMATICA,ELECTROHOGAR,HERRAMIENTAS;
	}
	
	private String codigo;
	private String descripcion;
	private double precioUnitario;
	private Origen origen;
	private Categoria cat;
	private boolean estado;
	
	public Producto(String codigo, String descripcion, double precioUnitario, Origen origen,
			Categoria cat, boolean estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origen = origen;
		this.cat = cat;
		this.estado=estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	public Categoria getCategoria() {
		return cat;
	}

	public void setCategoria(Categoria cat) {
		this.cat = cat;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado=estado;
	}
	
}
