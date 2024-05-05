package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoEfectivo implements IPago{
	private double montoPagado;
	private LocalDate fechaDePago;
	
	public PagoEfectivo (double montoPagado, LocalDate fechaDePago) {
		this.montoPagado = montoPagado;
		this.fechaDePago = fechaDePago;
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

	@Override
	public void realizarPago(double monto) {
		double descuento=monto*0.10;
		setMontoPagado(monto-descuento);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Precio sin descuento: "+montoPagado/0.90);
		System.out.println("Descuento por pago en efectivo: 10%");
		System.out.println("Precio real pagado: "+montoPagado);
		System.out.println("Fecha: "+fechaDePago);
	}

}
