package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Efemeride> listaEfemeride = new ArrayList<>();
		int indicador = 0;
		while (indicador != 5) {
			try {
				System.out.println("1-Crear Efemeride");
				System.out.println("2-Mostrar Efemeride");
				System.out.println("3-Eliminar Efemeride");
				System.out.println("4-Modificar Efemeride");
				System.out.println("5-Salir");

				indicador = scanner.nextInt();
				scanner.nextLine();
				switch (indicador) {
				case 1: {
					crearEfemeride(scanner, listaEfemeride);
					break;
				}
				case 2: {
					mostrarEfemeride(scanner, listaEfemeride);
					break;
				}
				case 3: {
					eliminarEfemeride(scanner, listaEfemeride);
					break;
				}
				case 4: {
					modificarEfemeride(scanner, listaEfemeride);
					break;
				}
				case 5: {
					System.out.println("Hasta Luego");
					break;
				}
				default: {
					System.out.println("Error. Ingrese numeros validos");
					break;
				}
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: Debe ingresar un número válido.");
				scanner.nextLine();
			}
		}
	}

	private static void crearEfemeride(Scanner scanner, ArrayList<Efemeride> listaEfemeride) {
		try {
			System.out.println("Ingrese codigo: ");
			String codigo = scanner.nextLine();
			System.out.println("Ingrese un numero correspondiente a un mes: ");
			int indicadorMes = scanner.nextInt();
			scanner.nextLine();
			if (indicadorMes < 1 || indicadorMes > 12) {
				throw new IllegalArgumentException(" mes incorrecto, intente nuevamente: ");
			}
			Mes mes = Mes.values()[indicadorMes - 1];
			System.out.println("Ingrese dia del mes: ");
			int dia = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Ingrese detalles de la efemerides: ");
			String detalles = scanner.nextLine();
			listaEfemeride.add(new Efemeride(codigo, mes, dia, detalles));
			System.out.println("Se creo la efemerides");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: valor incorrecto" + e.getMessage());
		}
		scanner.close();
	}

	private static void mostrarEfemeride(Scanner scanner, ArrayList<Efemeride> listaEfemeride) {
		int cont = 0;
		for (Efemeride e : listaEfemeride) {
			System.out.println("");
			System.out.println("Efemeride " + (cont + 1) + " :");
			System.out.println("Codigo: " + e.getCodigo());
			System.out.println("Mes: " + e.getMes());
			System.out.println("Dia: " + e.getDia());
			System.out.println("Detalle: " + e.getDetalle());
			System.out.println("==============================");
			cont++;
		}
		scanner.close();
	}

	private static void eliminarEfemeride(Scanner scanner, ArrayList<Efemeride> listaEfemeride) {
		if (listaEfemeride.isEmpty()) {
			System.out.println("No existen efemerides para borrar");
		}
		System.out.println("Ingrese codigo de la efemeride que desea borrar: ");
		String codigo = scanner.nextLine();
		scanner.nextLine();
		int identificador;
		for (Efemeride e : listaEfemeride) {
			if (e.getCodigo() == codigo) {
				System.out.println("1-Borrar de todos modos");
				System.out.println("2-Cancelar");
				identificador = scanner.nextInt();
				scanner.nextLine();
				if (identificador == 1) {
					listaEfemeride.remove(e);
					System.out.println("Efemeride eliminada......");
				} else {
				}
			} else {
				System.out.println("La efemeride no se encontro o ya fue borrada o no existe...");
			}
		}
		scanner.close();
	}

	private static void modificarEfemeride(Scanner scanner, ArrayList<Efemeride> listaEfemeride) {
		if (listaEfemeride.isEmpty()) {
			System.out.println("No existen efemérides para ser modificadas");
			return;
		}

		System.out.println("Ingrese el código de la efeméride que desea modificar: ");
		String codigo = scanner.nextLine();

		Efemeride modificarEfemeride = null;
		for (Efemeride e : listaEfemeride) {
			if (e.getCodigo().equals(codigo)) {
				modificarEfemeride = e;
				break;
			}
		}

		if (modificarEfemeride == null) {
			System.out.println("No se encontró ninguna efeméride con el código proporcionado");
			return;
		}

		System.out.println("Ingrese nuevo mes: ");
		int nuevoIndicadorMes = scanner.nextInt();
		scanner.nextLine();
		if (nuevoIndicadorMes < 1 || nuevoIndicadorMes > 12) {
			throw new IllegalArgumentException(" mes incorrecto, intente nuevamente: ");
		}
		Mes nuevoMes = Mes.values()[nuevoIndicadorMes - 1];
		modificarEfemeride.setMes(nuevoMes);

		System.out.println("Ingrese el nuevo día del mes: ");
		int nuevoDia;
		do {
			while (!scanner.hasNextInt()) {
				System.out.println("Entrada no válida. Por favor, ingrese un número entero: ");
				scanner.next(); // Limpiar el búfer de entrada
			}
			nuevoDia = scanner.nextInt();
			if (nuevoDia < 1 || nuevoDia > 31) {
				System.out.println("Día fuera de rango. Por favor, ingrese un número entre 1 y 31: ");
			}
		} while (nuevoDia < 1 || nuevoDia > 31);

		scanner.nextLine(); // Consumir nueva línea residual
		modificarEfemeride.setDia(nuevoDia);

		System.out.println("Ingrese los nuevos detalles de la efeméride: ");
		String nuevoDetalle = scanner.nextLine();
		modificarEfemeride.setDetalle(nuevoDetalle);

		System.out.println("Se ha modificado la efeméride exitosamente");
		scanner.close();
	}
}