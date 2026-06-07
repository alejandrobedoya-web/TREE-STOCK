import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crea una instancia del árbol para guardar las extensiones
        ArbolInventario miArbol = new ArbolInventario();
        Scanner sc = new Scanner(System.in);  // Objeto para leer datos del usuario
        int opcion = -1;  // Guardará la opción que elija el usuario

        // Bucle que muestra el menú hasta que el usuario elija salir (opción 0)
        while (opcion != 0) {
            System.out.println("\n--- INVENTARIO DE PRODUCTOS ---");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Ver Inventario Inorden (menor a mayor)");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Manejo de errores: si el usuario ingresa algo que no es un número
            try {
                opcion = sc.nextInt();  // Lee la opción del usuario
            } catch (Exception e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                sc.next();  // Limpia el buffer del Scanner
                continue;   // Vuelve a mostrar el menú
            }

            // Según la opción elegida, hace una cosa u otra
            switch (opcion) {
                case 1:  // Registrar nuevo producto
                    System.out.print("Ingrese código del producto: ");
                    try {
                        int id = sc.nextInt();
                        sc.nextLine();  // Limpia el buffer después de leer número
                        System.out.print("Nombre del producto: ");
                        String nombre = sc.nextLine();  // Lee el nombre
                        miArbol.insertar(id, nombre);   // Inserta en el árbol
                        System.out.println("Producto registrado con éxito.");
                    } catch (Exception e) {
                        System.out.println("ID debe ser un número válido.");
                        sc.next();
                    }
                    break;
                    
                case 2:
                    System.out.println("\nINORDEN (menor a mayor):");
                    miArbol.mostrarInorden(miArbol.getRaiz());
                    break;


                case 3:  // Buscar un producto por su ID
                    System.out.print("ID a buscar: ");
                    try {
                        int buscaId = sc.nextInt();
                        System.out.println(miArbol.buscar(buscaId));
                    } catch (Exception e) {
                        System.out.println("ID debe ser un número válido.");
                        sc.next();
                    }
                    break;

              
                    
                case 0:  // Salir del programa
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:  // Opción no válida
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();  // Cierra el Scanner cuando termina el programa
    }
}