package ar.edu.unju.fi.ejercicio07.model;

public class Producto {
	public enum origenFabricacion {
		BRASIL,ARGENTINA,CHINA,URUGUAY;
	}
	public enum Categoria{
		TELEFONIA,INFORMATICA,ELECTROHOGAR,HERRAMIENTAS;
	}
	private String codigo;
	private String descripcion;
	private double precioUnitario;
	private origenFabricacion origen;
	private Categoria cat;
	private boolean estado;
	
	public Producto(String codigo, String descripcion, double precioUnitario, origenFabricacion origen,
			Categoria cat, boolean estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origen = origen;
		this.cat = cat;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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

	public origenFabricacion getOrigen() {
		return origen;
	}

	public void setOrigen(origenFabricacion origen) {
		this.origen = origen;
	}

	public Categoria getCategoria() {
		return cat;
	}

	public void setCategoria(Categoria cat) {
		this.cat = cat;
	}
	
}
