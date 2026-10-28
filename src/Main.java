public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // 1. Agregar al menos 3 contactos (en desorden alfabetico a proposito)
        System.out.println("=== 1. AGREGAR CONTACTOS ===");
        agenda.agregarContacto(new Contacto("Carlos Gomez", "555-5678", "carlos@email.com"));
        agenda.agregarContacto(new Contacto("Beatriz Lopez", "555-4321", "beatriz@email.com"));
        agenda.agregarContacto(new Contacto("Ana Perez", "555-1234", "ana@email.com"));

        // 2. Listar contactos en orden alfabetico
        System.out.println("\n=== 2. LISTAR CONTACTOS ===");
        agenda.listarContactos();

        // 3. Listar historial en orden de insercion
        System.out.println("\n=== 3. LISTAR HISTORIAL ===");
        agenda.listarHistorial();

        // 4. Crear al menos 2 grupos
        System.out.println("\n=== 4. CREAR GRUPOS ===");
        agenda.agregarGrupo("Trabajo");
        agenda.agregarGrupo("Familia");

        // 5. Agregar contactos a grupos
        System.out.println("\n=== 5. AGREGAR CONTACTOS A GRUPOS ===");
        agenda.agregarContactoAGrupo("Ana Perez", "Trabajo");
        agenda.agregarContactoAGrupo("Carlos Gomez", "Trabajo");
        agenda.agregarContactoAGrupo("Beatriz Lopez", "Familia");

        // 6. Mostrar contactos por grupo
        System.out.println("\n=== 6. CONTACTOS POR GRUPO ===");
        agenda.mostrarContactosPorGrupo("Trabajo");
        agenda.mostrarContactosPorGrupo("Familia");

        // 7. Buscar un contacto existente
        System.out.println("\n=== 7. BUSCAR CONTACTO EXISTENTE ===");
        Contacto encontrado = agenda.buscarContacto("Ana Perez");
        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Contacto no encontrado: Ana Perez");
        }

        // 8. Buscar un contacto inexistente
        System.out.println("\n=== 8. BUSCAR CONTACTO INEXISTENTE ===");
        Contacto noEncontrado = agenda.buscarContacto("Pedro Ramos");
        if (noEncontrado != null) {
            System.out.println(noEncontrado);
        } else {
            System.out.println("Contacto no encontrado: Pedro Ramos");
        }

        // 9. Eliminar un contacto (esta en el grupo Trabajo)
        System.out.println("\n=== 9. ELIMINAR CONTACTO ===");
        if (agenda.eliminarContacto("Carlos Gomez")) {
            System.out.println("Contacto eliminado: Carlos Gomez");
        } else {
            System.out.println("Contacto no encontrado: Carlos Gomez");
        }
        System.out.println("-- Verificacion tras eliminar --");
        agenda.listarContactos();
        agenda.listarHistorial();
        agenda.mostrarContactosPorGrupo("Trabajo");

        // 10. Intentar agregar un contacto duplicado
        System.out.println("\n=== 10. AGREGAR CONTACTO DUPLICADO ===");
        agenda.agregarContacto(new Contacto("Ana Perez", "555-9999", "ana2@email.com"));
    }
}