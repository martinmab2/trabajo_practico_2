package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoTarjeta implements IPago{
	private double montoPagado;
	private LocalDate fechaDePago;
	private String numeroDeTarjeta;
	
	public PagoTarjeta(double montoPagado, LocalDate fechaDePago, String numeroDeTarjeta) {
		this.montoPagado = montoPagado;
		this.fechaDePago = fechaDePago;
		this.numeroDeTarjeta = numeroDeTarjeta;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public String getNumeroDeTarjeta() {
		return numeroDeTarjeta;
	}

	public void setNumeroDeTarjeta(String numeroDeTarjeta) {
		this.numeroDeTarjeta = numeroDeTarjeta;
	}

	@Override
	public void realizarPago(double monto) {
		double recargo=monto*0.15;
		setMontoPagado(monto+recargo);
	}

	@Override
	public void imprimirRecibo() {
		fechaDePago=LocalDate.now();
		System.out.println("Precio sin recargo: "+montoPagado/1.15);
		System.out.println("Recargo por pago con tarjeta: 15%");
		System.out.println("Precio real pagado: "+montoPagado);
		System.out.println("Fecha: "+fechaDePago);
		
	}
}
