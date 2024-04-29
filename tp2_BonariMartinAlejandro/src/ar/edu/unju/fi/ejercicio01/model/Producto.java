package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	public enum origenFabricacion {
		BRASIL,ARGENTINA,CHINA,URUGUAY;
	}
	public enum Categoria{
		TELEFONIA,INFORMATICA,ELECTROHOGAR,HERRAMIENTAS;
	}
	private int codigo;
	private String descripcion;
	private double precioUnitario;
	private origenFabricacion origen;
	private Categoria cat;
	
	public Producto(int codigo, String descripcion, double precioUnitario, origenFabricacion origen,
			Categoria cat) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origen = origen;
		this.cat = cat;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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
