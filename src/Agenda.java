import java.util.*;

public class Agenda {
    private Map<String, Contacto> busqueda = new TreeMap<>();
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> relacionGrupoContacto = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();

    public void agregarContacto(Contacto c) {
        if (busqueda.containsKey(c.getNombre())) {
            System.out.println("Error: Ya existe un contacto con el nombre '" + c.getNombre() + "'");
            return;
        }
        busqueda.put(c.getNombre(), c);
        historial.add(c);
        System.out.println("Contacto agregado: " + c.getNombre());
    }

    public Contacto buscarContacto(String nombre) {
        return busqueda.get(nombre);
    }

    public boolean eliminarContacto(String nombre) {
        Contacto eliminado = busqueda.remove(nombre);
        if (eliminado == null) {
            return false;
        }
        historial.removeIf(c -> c.getNombre().equals(nombre));
        for (Set<String> nombres : relacionGrupoContacto.values()) {
            nombres.remove(nombre);
        }
        return true;
    }

    public void listarContactos() {
        System.out.println("--- LISTA DE CONTACTOS (orden alfabetico) ---");
        for (Contacto c : busqueda.values()) {
            System.out.println(c);
        }
    }

    public void listarHistorial() {
        System.out.println("--- HISTORIAL (orden de insercion) ---");
        for (Contacto c : historial) {
            System.out.println(c);
        }
    }

    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' ya existe");
            return;
        }
        grupos.add(nombreGrupo);
        relacionGrupoContacto.put(nombreGrupo, new TreeSet<>());
        System.out.println("Grupo '" + nombreGrupo + "' creado");
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!busqueda.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto '" + nombreContacto + "' no existe");
            return;
        }
        if (!relacionGrupoContacto.containsKey(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }
        relacionGrupoContacto.get(nombreGrupo).add(nombreContacto);
        System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'");
    }

    public void listarGrupos() {
        System.out.println("--- GRUPOS (orden alfabetico) ---");
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos");
            return;
        }
        for (String grupo : grupos) {
            System.out.println(grupo);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        Set<String> nombres = relacionGrupoContacto.get(nombreGrupo);
        if (nombres == null) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }
        if (nombres.isEmpty()) {
            System.out.println("El grupo '" + nombreGrupo + "' no tiene contactos");
            return;
        }
        System.out.println("Contactos en '" + nombreGrupo + "':");
        for (String nombre : nombres) {
            System.out.println("- " + busqueda.get(nombre));
        }
    }
}