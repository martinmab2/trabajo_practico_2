package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Producto.Origen;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> listaDeProductos = new ArrayList<>();
        precarga(listaDeProductos);
        int entrada = 5;
        try {
            while (entrada != 3) {
                System.out.println("1- Mostrar Productos");
                System.out.println("2- Realizar Compra");
                System.out.println("3- Salir");
                entrada = scanner.nextInt();
                scanner.nextLine();

                switch (entrada) {
                    case 1: {
                        mostrarProductos(listaDeProductos, scanner);
                        break;
                    }
                    case 2: {
                        ArrayList<Producto> carrito = new ArrayList<>();
                        System.out.println("Estos son los Productos que [SI TIENEN STOCK]");
                        int id = 1;
                        for (Producto producto : listaDeProductos) {
                            if (producto.getEstado()) {
                                System.out.println("_____________________________________________");
                                System.out.println("Producto " + id + ": ");
                                System.out.println("Codigo: " + producto.getCodigo());
                                System.out.println("Descripcion: " + producto.getDescripcion());
                                System.out.println("Precio: " + producto.getPrecioUnitario() + "$");
                                System.out.println("Pais de fabricacion: " + producto.getOrigen());
                                System.out.println("Categoria: " + producto.getCategoria());
                                System.out.println("_____________________________________________");
                            }
                            id++;
                        }
                        boolean bandera = true;
                        while (bandera) {
                            System.out.println("Seleccione el producto que desea comprar mediante su codigo (ej:P01, P02, etc): ");
                            System.out.println("Ingrese fin para retractarse o ya no ingresar mas productos");
                            String codigoIngresado = scanner.nextLine();
                            if ("fin".equals(codigoIngresado)) {
                                bandera = false;
                                break;
                            } else {
                                boolean encontrado = false;
                                for (Producto producto : listaDeProductos) {
                                    if (codigoIngresado.equals(producto.getCodigo())) {
                                        encontrado = true;
                                        if (producto.getEstado()) {
                                            carrito.add(producto);
                                            break;
                                        } else {
                                            System.out.println("El producto actualmente no tiene Stock...");
                                            break;
                                        }
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("No se encontró ningún producto con ese código ");
                                }
                            }
                        }

                        if (carrito.isEmpty()) {
                            System.out.println("No seleccionó ningún producto para comprar");
                        } else {
                            double monto = 0;
                            System.out.println("Productos a comprar:  ");
                            for (Producto producto : carrito) {
                                System.out.println("");
                                System.out.println("Codigo: " + producto.getCodigo());
                                System.out.println("Descripcion: " + producto.getDescripcion());
                                System.out.println("Precio Unitario: " + producto.getPrecioUnitario() + "$");
                                System.out.println("Origen: " + producto.getOrigen());
                                System.out.println("Categoria: " + producto.getCategoria());
                                System.out.println("__________________________________________________");
                                monto += producto.getPrecioUnitario();
                            }
                            System.out.println("PRECIO TOTAL: " + monto + "$");
                            int ingreso = 0;
                            buclePago: while (ingreso != 3) {
                                System.out.println("_______________________________");
                                System.out.println("Ingrese su metodo de Pago: ");
                                System.out.println("1- Pago en Efectivo.");
                                System.out.println("2- Pago con Tarjeta");
                                System.out.println("3- Cancelar Compra");
                                System.out.println("_______________________________");
                                ingreso = scanner.nextInt();
                                scanner.nextLine();
                                switch (ingreso) {
                                    case 1: {
                                        PagoEfectivo pagoEfectivo = new PagoEfectivo(monto, LocalDate.now());
                                        pagoEfectivo.realizarPago(monto);
                                        pagoEfectivo.imprimirRecibo();
                                        break buclePago;
                                    }
                                    case 2: {
                                        System.out.println("Ingrese el numero de su tarjeta (12** **** **** **12)");
                                        String numeroTarjeta = scanner.nextLine();
                                        PagoTarjeta pagoTarjeta = new PagoTarjeta(monto, LocalDate.now(), numeroTarjeta);
                                        pagoTarjeta.realizarPago(monto);
                                        pagoTarjeta.imprimirRecibo();
                                        break buclePago;
                                    }
                                    case 3: {
                                        break buclePago;
                                    }
                                    default: {
                                        System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Adios...<3");
                        break;
                    }
                    default: {
                        System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                        break;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error de entrada: Por favor, ingrese un número válido.");
        } finally {
            scanner.close();
        }
    }

	private static void precarga(ArrayList<Producto> listaDeProductos) {
		Producto producto01 = new Producto("P01", "Teléfono inteligente con pantalla táctil", 300000.0, Origen.CHINA,
				Categoria.TELEFONIA, true);
		Producto producto02 = new Producto("P02", "Computadora portátil con pantalla de 15 pulgadas", 800000.0,
				Origen.ARGENTINA, Categoria.INFORMATICA, true);
		Producto producto03 = new Producto("P03", "Cafetera que prepara hasta 12 tazas de café", 50000.0,
				Origen.URUGUAY, Categoria.ELECTROHOGAR, true);
		Producto producto04 = new Producto("P04", "Taladro eléctrico sin cables, con batería recargable", 120000.0,
				Origen.BRASIL, Categoria.HERRAMIENTAS, false);
		Producto producto05 = new Producto("P05", "Auriculares inalámbricos con cancelación de ruido", 60000.0,
				Origen.CHINA, Categoria.TELEFONIA, false);
		Producto producto06 = new Producto("P06", "Monitor de pantalla plana con resolución Full HD", 170000.0,
				Origen.ARGENTINA, Categoria.INFORMATICA, true);
		Producto producto07 = new Producto("P07", "Aspiradora automática con sensor de obstáculos", 155000.0,
				Origen.URUGUAY, Categoria.ELECTROHOGAR, false);
		Producto producto08 = new Producto("P08", "Destornillador recargable con diferentes puntas", 40000.0,
				Origen.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto producto09 = new Producto("P09", "Funda protectora de silicona para teléfono móvil", 3000.0,
				Origen.CHINA, Categoria.TELEFONIA, true);
		Producto producto10 = new Producto("P10", "Impresora, copiadora y escáner todo en uno", 125500.0,
				Origen.ARGENTINA, Categoria.INFORMATICA, false);
		Producto producto11 = new Producto("P11", "Plancha con base de cerámica y vapor vertical", 30000.0,
				Origen.URUGUAY, Categoria.ELECTROHOGAR, false);
		Producto producto12 = new Producto("P12", "Conjunto de llaves de diferentes tamaños", 15200.0, Origen.BRASIL,
				Categoria.HERRAMIENTAS, false);
		Producto producto13 = new Producto("P13", "Batería externa para cargar dispositivos móviles", 20000.0,
				Origen.CHINA, Categoria.TELEFONIA, true);
		Producto producto14 = new Producto("P14", "Router inalámbrico de doble banda para redes domésticas", 80000.0,
				Origen.ARGENTINA, Categoria.INFORMATICA, true);
		Producto producto15 = new Producto("P15", "Horno con capacidad para 6 bandejas y funciones programables",
				250000.0, Origen.URUGUAY, Categoria.ELECTROHOGAR, true);
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

	private static void mostrarProductos(ArrayList<Producto> listaDeProductos, Scanner scanner) {
		System.out.println("PRODUCTOS: " + "/n");
		int id = 1;
		for (Producto producto : listaDeProductos) {
			System.out.println("Producto " + id + ": ");
			System.out.println("Codigo: " + producto.getCodigo());
			System.out.println("Descripcion: " + producto.getDescripcion());
			System.out.println("Precio: " + producto.getPrecioUnitario() + "$");
			System.out.println("Pais de fabricacion: " + producto.getOrigen());
			System.out.println("Categoria: " + producto.getCategoria());
			if (producto.getEstado() == true) {
				System.out.println("Hay stock");
			} else {
				System.out.println("No hay stock");
			}
			System.out.println("================================================");
			id++;
		}
	}
}