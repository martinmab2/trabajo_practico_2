package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio07.model.Producto;
import ar.edu.unju.fi.ejercicio07.model.Producto.Categoria;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		ArrayList<Producto> listaDeProductos = new ArrayList<>();
		precarga(listaDeProductos);
		int ingreso;
		do {
			System.out.println("Menu Principal:");
			System.out.println("1- Mostrar productos (solo con estado true)");
			System.out.println("2- Mostrar productos faltantes (estado false)");
			System.out.println("3- Incrementar precios de los productos en un 20%");
			System.out.println("4- Mostrar productos de la categoría Electrohogar y disponibles");
			System.out.println("5- Ordenar productos por precio de forma descendente");
			System.out.println("6- Mostrar nombres de productos en mayúsculas");
			System.out.println("0- Salir");
			System.out.print("ingrese numero entero: ");
			ingreso = scanner.nextInt();

			switch (ingreso) {
			case 1:
				listaDeProductos.stream().filter(Producto::isEstado).forEach(producto -> {
					System.out.println("Código: " + producto.getCodigo());
					System.out.println("Descripción: " + producto.getDescripcion());
					System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
					System.out.println("Categoría: " + producto.getCategoria());
					System.out.println("Origen de Fabricación: " + producto.getOrigen());
					System.out.println("Estado: " + producto.isEstado());
					System.out.println();
				});
				break;
			case 2:
				listaDeProductos.stream().filter(producto -> !producto.isEstado()).forEach(producto -> {
					System.out.println("Código: " + producto.getCodigo());
					System.out.println("Descripción: " + producto.getDescripcion());
					System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
					System.out.println("Categoría: " + producto.getCategoria());
					System.out.println("Origen de Fabricación: " + producto.getOrigen());
					System.out.println("Estado: " + producto.isEstado());
					System.out.println();
				});
				break;
			case 3:
			    ArrayList<Producto> productosIncrementados = new ArrayList<>();
			    listaDeProductos.stream().map(producto -> {
			        double nuevoPrecio = producto.getPrecioUnitario() * 1.2;
			        Producto productoIncrementado = new Producto(producto.getCodigo(), producto.getDescripcion(), nuevoPrecio,
			        		producto.getOrigen(),producto.getCategoria(), producto.isEstado());
			        productosIncrementados.add(productoIncrementado);
			        return productoIncrementado;
			    }).forEach(producto -> {
			        System.out.println("Código: " + producto.getCodigo());
			        System.out.println("Descripción: " + producto.getDescripcion());
			        System.out.println("Precio con 20% de aumento: " + producto.getPrecioUnitario());
			        System.out.println("Categoría: " + producto.getCategoria());
			        System.out.println("Origen de Fabricación: " + producto.getOrigen());
			        System.out.println("Estado: " + producto.isEstado());
			        System.out.println();
			    });
			    break;
			case 4:
			    listaDeProductos.stream().filter(
			            producto -> producto.getCategoria() == Categoria.ELECTROHOGAR && producto.isEstado())
			            .forEach(producto -> {
			                System.out.println("Código: " + producto.getCodigo());
			                System.out.println("Descripción: " + producto.getDescripcion());
			                System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
			                System.out.println("Categoría: " + producto.getCategoria());
			                System.out.println("Origen de Fabricación: " + producto.getOrigen());
			                System.out.println("Estado: " + producto.isEstado());
			                System.out.println();
			            });
			    break;
			case 5:
			    listaDeProductos.stream().sorted((p1, p2) -> Double.compare(p2.getPrecioUnitario(), p1.getPrecioUnitario()))
			            .forEach(producto -> {
			                System.out.println("Código: " + producto.getCodigo());
			                System.out.println("Descripción: " + producto.getDescripcion());
			                System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
			                System.out.println("Categoría: " + producto.getCategoria());
			                System.out.println("Origen de Fabricación: " + producto.getOrigen());
			                System.out.println("Estado: " + producto.isEstado());
			                System.out.println();
			            });
			    break;
			case 6:
			    listaDeProductos.stream().map(producto -> {
			        Producto productoMayusculas = new Producto(producto.getCodigo(), producto.getDescripcion().toUpperCase(), producto.getPrecioUnitario(),
			        		producto.getOrigen(),producto.getCategoria(),producto.isEstado());
			        return productoMayusculas;
			    }).forEach(producto -> {
			        System.out.println("Código: " + producto.getCodigo());
			        System.out.println("Descripción: " + producto.getDescripcion());
			        System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
			        System.out.println("Categoría: " + producto.getCategoria());
			        System.out.println("Origen de Fabricación: " + producto.getOrigen());
			        System.out.println("Estado: " + producto.isEstado());
			        System.out.println();
			    });
			    break;

			case 0:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
				break;
			}
		} while (ingreso != 0);
		scanner.close();
	}

	private static void precarga(ArrayList<Producto> listaDeProductos) {
	    Producto producto01 = new Producto("P01", "Teléfono inteligente con pantalla táctil", 300000.0, Producto.origenFabricacion.CHINA,
	            Producto.Categoria.TELEFONIA, true);
	    Producto producto02 = new Producto("P02", "Computadora portátil con pantalla de 15 pulgadas", 800000.0,
	            Producto.origenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, true);
	    Producto producto03 = new Producto("P03", "Cafetera que prepara hasta 12 tazas de café", 50000.0,
	            Producto.origenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, true);
	    Producto producto04 = new Producto("P04", "Taladro eléctrico sin cables, con batería recargable", 120000.0,
	            Producto.origenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS, false);
	    Producto producto05 = new Producto("P05", "Auriculares inalámbricos con cancelación de ruido", 60000.0,
	            Producto.origenFabricacion.CHINA, Producto.Categoria.TELEFONIA, false);
	    Producto producto06 = new Producto("P06", "Monitor de pantalla plana con resolución Full HD", 170000.0,
	            Producto.origenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, true);
	    Producto producto07 = new Producto("P07", "Aspiradora automática con sensor de obstáculos", 155000.0,
	            Producto.origenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, false);
	    Producto producto08 = new Producto("P08", "Destornillador recargable con diferentes puntas", 40000.0,
	            Producto.origenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS, true);
	    Producto producto09 = new Producto("P09", "Funda protectora de silicona para teléfono móvil", 3000.0,
	            Producto.origenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true);
	    Producto producto10 = new Producto("P10", "Impresora, copiadora y escáner todo en uno", 125500.0,
	            Producto.origenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, false);
	    Producto producto11 = new Producto("P11", "Plancha con base de cerámica y vapor vertical", 30000.0,
	            Producto.origenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, false);
	    Producto producto12 = new Producto("P12", "Conjunto de llaves de diferentes tamaños", 15200.0, Producto.origenFabricacion.BRASIL,
	            Producto.Categoria.HERRAMIENTAS, false);
	    Producto producto13 = new Producto("P13", "Batería externa para cargar dispositivos móviles", 20000.0,
	            Producto.origenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true);
	    Producto producto14 = new Producto("P14", "Router inalámbrico de doble banda para redes domésticas", 80000.0,
	            Producto.origenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, true);
	    Producto producto15 = new Producto("P15", "Horno con capacidad para 6 bandejas y funciones programables",
	            250000.0, Producto.origenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, true);
	    listaDeProductos.add(producto01);
	    listaDeProductos.add(producto02);
	    listaDeProductos.add(producto03);
	    listaDeProductos.add(producto04);
	    listaDeProductos.add(producto05);
	    listaDeProductos.add(producto06);
	    listaDeProductos.add(producto07);
	    listaDeProductos.add(producto08);
	    listaDeProductos.add(producto09);
	    listaDeProductos.add(producto10);
	    listaDeProductos.add(producto11);
	    listaDeProductos.add(producto12);
	    listaDeProductos.add(producto13);
	    listaDeProductos.add(producto14);
	    listaDeProductos.add(producto15);
	}

}
