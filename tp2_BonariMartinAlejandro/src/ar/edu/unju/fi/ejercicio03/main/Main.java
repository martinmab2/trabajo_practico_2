package ar.edu.unju.fi.ejercicio03.main;
import ar.edu.unju.fi.ejercicio03.constantes.Provincia;
public class Main {

	public static void main(String[] args) {
		Provincia[] provincias=Provincia.values();
		for(Provincia provincia:provincias) {
			System.out.println("======================================");
			System.out.println("Provincia: " + provincia);
			System.out.println("Poblacion: " + provincia.getPoblacion()+"(hab)");
			System.out.println("Superficie: " + provincia.getSuperficie()+"(Km2)");
			System.out.println("Densidad Poblacional: "+provincia.calcularDensidad()+"(hab/km2)");
		}
	}
}
