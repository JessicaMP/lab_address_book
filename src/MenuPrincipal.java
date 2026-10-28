import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private static final List<String> OPTIONS = List.of(
            "Agregar contacto",
            "Buscar contacto",
            "Eliminar contacto",
            "Listar contactos (orden alfabetico)",
            "Listar historial (orden de insercion)",
            "Agregar grupo",
            "Agregar contacto a grupo",
            "Listar grupos",
            "Mostrar contactos por grupo",
            "Salir"
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int option = 0;

        while (option != 10) {
            showMenu();

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Opcion invalida, intenta de nuevo");
                option = 0;
                continue;
            }

            option = scanner.nextInt();
            scanner.nextLine();

            selectOption(option, scanner, agenda);
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("=== AGENDA DE CONTACTOS ===");
        for (int i = 0; i < OPTIONS.size(); i++) {
            System.out.println((i + 1) + ". " + OPTIONS.get(i));
        }
        System.out.println("==========================");
        System.out.print("Elige una opcion: ");
    }

    private static void selectOption(int option, Scanner scanner, Agenda agenda) {
        switch (option) {
            case 1: {
                System.out.println("--- AGREGAR CONTACTO ---");
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Telefono: ");
                String telefono = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                agenda.agregarContacto(new Contacto(nombre, telefono, email));
                break;
            }
            case 2: {
                System.out.print("Nombre a buscar: ");
                String nombre = scanner.nextLine();
                Contacto c = agenda.buscarContacto(nombre);
                if (c != null) {
                    System.out.println(c);
                } else {
                    System.out.println("Contacto no encontrado: " + nombre);
                }
                break;
            }
            case 3: {
                System.out.print("Nombre a eliminar: ");
                String nombre = scanner.nextLine();
                if (agenda.eliminarContacto(nombre)) {
                    System.out.println("Contacto eliminado: " + nombre);
                } else {
                    System.out.println("Contacto no encontrado: " + nombre);
                }
                break;
            }
            case 4:
                agenda.listarContactos();
                break;
            case 5:
                agenda.listarHistorial();
                break;
            case 6: {
                System.out.print("Nombre del grupo: ");
                String grupo = scanner.nextLine();
                agenda.agregarGrupo(grupo);
                break;
            }
            case 7: {
                System.out.print("Nombre del contacto: ");
                String nombre = scanner.nextLine();
                System.out.print("Nombre del grupo: ");
                String grupo = scanner.nextLine();
                agenda.agregarContactoAGrupo(nombre, grupo);
                break;
            }
            case 8:
                agenda.listarGrupos();
                break;
            case 9: {
                System.out.print("Nombre del grupo: ");
                String grupo = scanner.nextLine();
                agenda.mostrarContactosPorGrupo(grupo);
                break;
            }
            case 10:
                System.out.println("Saliendo de la agenda...");
                break;
            default:
                System.out.println("Opcion invalida, intenta de nuevo");
        }
    }
}