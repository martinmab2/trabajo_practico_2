package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(811611,53219),
	SALTA(1441351,155488),
	TUCUMAN(1448200,22524), 
	CATAMARCA(429562,102602),
	LARIOJA(383865,89680),
	SANTIAGODELESTERO(896461,136351);
	
	private final long poblacion;
	private final long superficie;
	
	
	
	private Provincia(long poblacion, long superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}
	public long getPoblacion() {
		return poblacion;
	}
	public long getSuperficie() {
		return superficie;
	}
	
	public float calcularDensidad() {
		float densidad=(float) poblacion/superficie;
		return densidad;
		}
	}

