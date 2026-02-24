Package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private List<Libro> prestamosActivos;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.prestamosActivos = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Libro> getPrestamosActivos() { return prestamosActivos; }

    public void agregarPrestamo(Libro libro) throws Exception {
        if (prestamosActivos.size() >= 3)
            throw new Exception("Limite de 3 libros excedido");
        prestamosActivos.add(libro);
    }

    public void devolverPrestamo(Libro libro) {
        prestamosActivos.remove(libro);
    }

    public String mostrarInfo() {
        return nombre + " - Libros prestados: " + prestamosActivos.size();
    }
}
