import java.util.Scanner;

public class GestionEmpresa {

    // Array global para almacenar empleados
    private static Empleado[] empleados = new Empleado[100];
    private static int contador = 0;


    public static void contratarEmpleado(String nombre, double salario, String departamento) {
        if (contador < empleados.length) {
            empleados[contador] = new Empleado(nombre, salario, departamento);
            contador++;
            System.out.println("Empleado contratado correctamente.");
        } else {
            System.out.println("No se pueden añadir más empleados.");
        }
    }

    public static void mostrarEmpleados() {
        if (contador == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        System.out.println("LISTA DE EMPLEADOS");
        for (int i = 0; i < contador; i++) {
            System.out.println(empleados[i]);
        }
        System.out.println();
    }

    // Calcular nómina total
    public static double calcularNominaTotal() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += empleados[i].getSalario();
        }
        return total;
    }

    // Buscar empleado por nombre
    public static void buscarEmpleado(String nombre) {
        boolean encontrado = false;

        for (int i = 0; i < contador; i++) {
            if (empleados[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Empleado encontrado:");
                System.out.println(empleados[i] + "");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un empleado con ese nombre.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("====== GESTIÓN DE EMPRESA ======");
            System.out.println("1. Contratar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Calcular nómina total");
            System.out.println("4. Buscar empleado por nombre");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Departamento: ");
                    String departamento = sc.nextLine();
                    contratarEmpleado(nombre, salario, departamento);
                    break;

                case 2:
                    mostrarEmpleados();
                    break;

                case 3:
                    System.out.println("La nómina total es: " + calcularNominaTotal() + " ");
                    break;

                case 4:
                    System.out.print("Nombre del empleado a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    buscarEmpleado(nombreBuscar);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 5);
    }
}
