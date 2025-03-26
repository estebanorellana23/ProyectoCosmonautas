package GestionDeMisiones;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolAvlAstronautas arbol = new ArbolAvlAstronautas();
        ListaDinamicaMisiones listaMisiones = new ListaDinamicaMisiones();
        
        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar Astronauta");
            System.out.println("2. Eliminar Astronauta");
            System.out.println("3. Crear Misión");
            System.out.println("4. Listar Misiones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nacionalidad = scanner.nextLine();
                    System.out.print("Horas de experiencia: ");
                    int horas = scanner.nextInt();
                    scanner.nextLine();
                    
                    Astronauta astronauta = new Astronauta(nombre, apellido, nacionalidad);
                    arbol.insertar(astronauta, horas);
                    System.out.println("Astronauta agregado con éxito.");
                    break;
                
                case 2:
                    if (arbol.raiz == null) {
                        System.out.println("No hay astronautas para eliminar.");
                        break;
                    }
                    System.out.print("Ingrese el nombre del astronauta a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    arbol.eliminarPorNombre(nombreEliminar);
                    System.out.println("Astronauta eliminado.");
                    break;
                
                case 3:
                    System.out.print("Ingrese el nombre de la misión: ");
                    String nomMision = scanner.nextLine();
                    NodoMision nuevaMision = new NodoMision(nomMision);
                    System.out.print("Ingrese el número de astronautas (máximo 4): ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (nuevaMision.agregarAstronautas(cantidad, arbol)) {
                        listaMisiones.insertarMision(nuevaMision);
                        System.out.println("Misión creada con éxito.");
                    } else {
                        System.out.println("Error al asignar astronautas.");
                    }
                    break;
                
                case 4:
                    listaMisiones.listarMision();
                    break;
                
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}
