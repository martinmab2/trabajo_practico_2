package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Jugador> listaJugadores = new ArrayList<>();

	        int opcion = 0;
	        while (opcion != 5) {
	            try {
	                System.out.println("Menú:");
	                System.out.println("1 - Alta de jugador");
	                System.out.println("2 - Mostrar todos los jugadores");
	                System.out.println("3 - Modificar la posición de un jugador");
	                System.out.println("4 - Eliminar un jugador");
	                System.out.println("5 - Salir");
	                System.out.print("Ingrese la opción deseada: ");
	                opcion = scanner.nextInt();
	                scanner.nextLine(); 

	                switch (opcion) {
	                    case 1:
	                        altaJugador(scanner, listaJugadores);
	                        break;
	                    case 2:
	                        mostrarJugadores(listaJugadores);
	                        break;
	                    case 3:
	                        modificarPosicion(scanner, listaJugadores);
	                        break;
	                    case 4:
	                        eliminarJugador(scanner, listaJugadores);
	                        break;
	                    case 5:
	                        System.out.println("Saliendo del programa...");
	                        break;
	                    default:
	                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
	                        break;
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Error: Debe ingresar un número.");
	                scanner.nextLine(); 
	            }
	        }

	        scanner.close();
	    }

	    private static void altaJugador(Scanner scanner, ArrayList<Jugador> listaJugadores) {
	    	    System.out.println("Ingrese los datos del nuevo jugador:");

	    	    System.out.print("Nombre: ");
	    	    String nombre = scanner.nextLine();

	    	    System.out.print("Apellido: ");
	    	    String apellido = scanner.nextLine();

	    	    System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
	    	    String fechaNacimientoStr = scanner.nextLine();
	    	    LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);

	    	    System.out.print("Nacionalidad: ");
	    	    String nacionalidad = scanner.nextLine();

	    	    System.out.print("Estatura (cm): ");
	    	    double estatura = scanner.nextDouble();

	    	    System.out.print("Peso (kg): ");
	    	    double peso = scanner.nextDouble();
	    	    scanner.nextLine(); 

	    	    System.out.println("Posición:");
	    	    System.out.println("1 - DELANTERO");
	    	    System.out.println("2 - MEDIO");
	    	    System.out.println("3 - DEFENSA");
	    	    System.out.println("4 - ARQUERO");
	    	    System.out.print("Seleccione la posición del jugador: ");
	    	    int opcionPosicion = scanner.nextInt();
	    	    scanner.nextLine(); 

	    	    Posicion posicion=null;
	    	    switch (opcionPosicion) {
	    	        case 1:
	    	            posicion = Posicion.DELANTERO;
	    	            break;
	    	        case 2:
	    	            posicion = Posicion.MEDIO;
	    	            break;
	    	        case 3:
	    	            posicion = Posicion.DEFENSA;
	    	            break;
	    	        case 4:
	    	            posicion = Posicion.ARQUERO;
	    	            break;
	    	        default:
	    	            System.out.println("Opción inválida. Se asignará la posición por defecto (DEFENSA).");
	    	            posicion = Posicion.DEFENSA;
	    	            break;
	    	    }

	    	    Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
	    	    listaJugadores.add(nuevoJugador);

	    	    System.out.println("¡Nuevo jugador agregado!");
	    	
	    }
	    private static void mostrarJugadores(ArrayList<Jugador> listaJugadores) {
	        if (listaJugadores.isEmpty()) {
	            System.out.println("No hay jugadores registrados.");
	        } else {
	            System.out.println("Listado de jugadores:");
	            for (Jugador jugador : listaJugadores) {
	                System.out.println("Nombre: " + jugador.getNombre());
	                System.out.println("Apellido: " + jugador.getApellido());
	                System.out.println("Fecha de nacimiento: " + jugador.getFechaNacimiento());
	                System.out.println("Nacionalidad: " + jugador.getNacionalidad());
	                System.out.println("Estatura: " + jugador.getEstatura() + " metros");
	                System.out.println("Peso: " + jugador.getPeso() + " kg");
	                System.out.println("Posición: " + jugador.getPosicion());
	                System.out.println("-------------------------------------");
	            }
	        }
	    }
	    private static void modificarPosicion(Scanner scanner, ArrayList<Jugador> listaJugadores) {
	        if (listaJugadores.isEmpty()) {
	            System.out.println("No hay jugadores registrados.");
	            return;
	        }

	        System.out.print("Ingrese el nombre del jugador que desea modificar: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Ingrese el apellido del jugador que desea modificar: ");
	        String apellido = scanner.nextLine();

	        Jugador jugadorModificar = null;
	        for (Jugador jugador : listaJugadores) {
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                jugadorModificar = jugador;
	                break;
	            }
	        }

	        if (jugadorModificar == null) {
	            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
	            return;
	        }

	        System.out.println("El jugador encontrado es:");
	        System.out.println("Nombre: " + jugadorModificar.getNombre());
	        System.out.println("Apellido: " + jugadorModificar.getApellido());
	        System.out.println("Posición actual: " + jugadorModificar.getPosicion());
	        System.out.println();

	        System.out.print("Ingrese la nueva posición del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
	        String nuevaPosicionStr = scanner.nextLine();

	        Posicion nuevaPosicion;
	        try {
	            nuevaPosicion = Posicion.valueOf(nuevaPosicionStr.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: Posición inválida. Debe ingresar una de las opciones: DELANTERO, MEDIO, DEFENSA, ARQUERO.");
	            return;
	        }

	        jugadorModificar.setPosicion(nuevaPosicion);
	        System.out.println("La posición del jugador ha sido modificada exitosamente.");
	    }
	    private static void eliminarJugador(Scanner scanner, ArrayList<Jugador> listaJugadores) {
	        if (listaJugadores.isEmpty()) {
	            System.out.println("No hay jugadores registrados.");
	            return;
	        }

	        System.out.print("Ingrese el nombre del jugador que desea eliminar: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Ingrese el apellido del jugador que desea eliminar: ");
	        String apellido = scanner.nextLine();

	        Jugador jugadorEliminar = null;
	        for (Jugador jugador : listaJugadores) {
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                jugadorEliminar = jugador;
	                break;
	            }
	        }

	        if (jugadorEliminar == null) {
	            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
	            return;
	        }

	        listaJugadores.remove(jugadorEliminar);
	        System.out.println("El jugador ha sido eliminado correctamente.");
	    }
	}