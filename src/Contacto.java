public class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    // Constructor
    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    //    Getters
    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    //    Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString() {
//        System.out.println("Nombre: " + this.nombre
//                + " | " + "Teléfono: " + this.telefono
//                + " | " + "Email: " + this.email);
        String message = "Nombre: " + this.nombre
                + " | " + "Teléfono: " + this.telefono
                + " | " + "Email: " + this.email;

        return message;
    }
}
