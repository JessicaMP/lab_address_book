import java.util.*;

public class Agenda {
    private Map<String, Contacto> busqueda = new TreeMap<>();
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> relacionGrupoContacto = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();

    // methods
    public void agregarContact(Contacto c) {
        if (busqueda.containsKey(c.getNombre())) {
            System.out.println("Error: el contacto '" + c.getNombre() + "' ya existe.");
            return;
        }
        busqueda.put(c.getNombre(), c);
        historial.add(c);
    }

    public Contacto buscarContact(String nombre) {
        return busqueda.get(nombre);
    }
    public Boolean eliminarContacto(String nombre) {
        Contacto eliminado = busqueda.remove(nombre);
        if (eliminado == null) {
            return false;
        }

        historial.removeIf(c -> c.getNombre().equals(nombre));

        for (Set<String> names : relacionGrupoContacto.values()) {
            names.remove(nombre);
        }
        return true;
    }
    public void listarContactos() {
        System.out.println("Contactos (ordenado): " + busqueda.values());
    }
    public void listarHistorial() {
        System.out.println("Contatos (insercion): " + historial);
    }
    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: el grupo '" + nombreGrupo + "' ya existe.");
            return;
        }
        grupos.add(nombreGrupo);
        relacionGrupoContacto.put(nombreGrupo, new TreeSet<>());
    }
    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!busqueda.containsKey(nombreContacto)) {
            System.out.println("Error: el contacto '" + nombreContacto + "' no existe.");
            return;
        }
        if (!relacionGrupoContacto.containsKey(nombreGrupo)) {
            System.out.println("Error: el grupo '" + nombreGrupo + "' no existe.");
            return;
        }
        relacionGrupoContacto.get(nombreGrupo).add(nombreContacto);
    }
    public void listarGrupos() {
        for (String group : grupos) {
            System.out.println(group);
        }
    }
    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!relacionGrupoContacto.containsKey(nombreGrupo)) {
            System.out.println("Error: el grupo '" + nombreGrupo + "' no existe.");
            return;
        }
        Set<String> nombres = relacionGrupoContacto.get(nombreGrupo);

        if (nombres.isEmpty()) {
            System.out.println("El grupo '" + nombreGrupo + "' está vacío.");
            return;
        }

        System.out.println("Contactos del grupo '" + nombreGrupo + "':");
        for (String nombre : nombres) {
            System.out.println("- " + nombre);
        }
    }
}
