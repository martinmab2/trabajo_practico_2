package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.origenFabricacion;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> listadoProductos = new ArrayList<>();
        int finalizador = 0;

        try {
            while (finalizador != 4) {
                System.out.println("1)__Crear Producto");
                System.out.println("2)__Mostrar Producto");
                System.out.println("3)__Modificar Producto");
                System.out.println("4)__Salir");
                finalizador = scanner.nextInt();
                scanner.nextLine();

                switch (finalizador) {
                    case 1: {
                        crearProducto(scanner, listadoProductos);
                        break;
                    }
                    case 2: {
                        mostrarProductos(listadoProductos);
                        break;
                    }
                    case 3: {
                        modificarProducto(scanner, listadoProductos);
                        break;
                    }
                    case 4: {
                        System.out.println("Saliendo del programa...");
                        break;
                    }
                    default: {
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: La entrada no es válida.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
        scanner.close();
    }

    private static void crearProducto(Scanner scanner, ArrayList<Producto> listadoProductos) {
        try {
            System.out.println("Ingrese codigo del producto: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese descripcion del producto: ");
            String descripcion = scanner.nextLine();
            System.out.println("Ingrese precio (por unidad): ");
            double precioUnitario = scanner.nextDouble();
            System.out.println("Ingrese pais de fabricacion del producto: ");
            System.out.println("ingrese la opcion deseada:");
            System.out.println("1-Argentina");
            System.out.println("2-Uruguay");
            System.out.println("3-Brasil");
            System.out.println("4-China");
            int auxiliar = scanner.nextInt();
            origenFabricacion origen;
            switch (auxiliar) {
                case 1:
                    origen = origenFabricacion.ARGENTINA;
                    break;
                case 2:
                    origen = origenFabricacion.URUGUAY;
                    break;
                case 3:
                    origen = origenFabricacion.BRASIL;
                    break;
                default:
                    origen = origenFabricacion.CHINA;
                    break;
            }
            System.out.println("Ingrese categoria: ");
            System.out.println("1-Telefonía");
            System.out.println("2-Herramientas");
            System.out.println("3-Informatica");
            System.out.println("4-Electro Hogar");
            System.out.println("ingrese el valor entero deseado");
            int identificador = scanner.nextInt();
            Categoria cat;
            switch (identificador) {
                case 1:
                    cat = Categoria.TELEFONIA;
                    break;
                case 2:
                    cat = Categoria.HERRAMIENTAS;
                    break;
                case 3:
                    cat = Categoria.INFORMATICA;
                    break;
                default:
                    cat = Categoria.ELECTROHOGAR;
                    break;
            }
            /* creacion del producto */

            Producto producto = new Producto(codigo, descripcion, precioUnitario, origen, cat);
            listadoProductos.add(producto);
        } catch (InputMismatchException e) {
            System.out.println("Error: La entrada no es válida.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    private static void mostrarProductos(ArrayList<Producto> listadoProductos) {
        int contador = 1;
        if (listadoProductos.isEmpty()) {
            System.out.println("No hay productos alojados para mostrar");
        } else {
            System.out.println("Productos Guardados: ");
            for (Producto producto : listadoProductos) {
                System.out.println("____________________________________");
                System.out.println("Codigo producto" + contador + " : " + producto.getCodigo());
                System.out.println("Descripcion del producto" + contador + " : " + producto.getDescripcion());
                System.out.println("Precio del producto" + contador + " : " + producto.getPrecioUnitario() + "$");
                System.out.println("Pais de origen del producto" + contador + producto.getOrigen());
                System.out.println("Categoria" + contador + " : " + producto.getCategoria());
                contador++;
            }
        }
    }

    private static void modificarProducto(Scanner scanner, ArrayList<Producto> listadoProductos) {
        try {
            if (listadoProductos.isEmpty()) {
                System.out.println("No hay productos alojados, disponibles de modificar");
            } else {
                System.out.println("Ingrese el codigo del producto que desea modificar: ");
                int codigoModificar = scanner.nextInt();
                scanner.nextLine();
                for (Producto producto : listadoProductos) {
                    if (producto.getCodigo() == codigoModificar) {
                        System.out.println("Ingrese nueva descripción : ");
                        String descripcion = scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("Ingrese nuevo precio: ");
                        double precioUnitario = scanner.nextDouble();
                        System.out.println("Elija la nueva categoria de su producto:");
                        System.out.println("1-Telefonía");
                        System.out.println("2-Herramientas");
                        System.out.println("3-Informatica");
                        System.out.println("4-Electro Hogar");
                        System.out.println("ingrese el valor entero deseado");
                        int identificador = scanner.nextInt();
                        Categoria cat;
                        switch (identificador) {
                            case 1:
                                cat = Categoria.TELEFONIA;
                                break;
                            case 2:
                                cat = Categoria.HERRAMIENTAS;
                                break;
                            case 3:
                                cat = Categoria.INFORMATICA;
                                break;
                            default:
                                cat = Categoria.ELECTROHOGAR;
                                break;
                        }
                        System.out.println("Elija el nuevo origen de su producto");
                        System.out.println("1-Argentina");
                        System.out.println("2-Uruguay");
                        System.out.println("3-Brasil");
                        System.out.println("4-China");
                        int auxiliar = scanner.nextInt();
                        origenFabricacion origen;
                        switch (auxiliar) {
                            case 1:
                                origen = origenFabricacion.ARGENTINA;
                                break;
                            case 2:
                                origen = origenFabricacion.URUGUAY;
                                break;
                            case 3:
                                origen = origenFabricacion.BRASIL;
                                break;
                            default:
                                origen = origenFabricacion.CHINA;
                                break;
                        }
                        producto.setDescripcion(descripcion);
                        producto.setPrecioUnitario(precioUnitario);
                        producto.setCategoria(cat);
                        producto.setOrigen(origen);
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: La entrada no es válida.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
