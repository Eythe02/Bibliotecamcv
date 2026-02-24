package Controlador;

import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public GestorBiblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void prestarLibro(String isbn, String idUsuario) throws Exception {
        Libro libro = buscarLibroISBN(isbn);
        Usuario usuario = buscarUsuarioID(idUsuario);
        if (libro == null || usuario == null) throw new Exception("Libro o usuario no encontrado");
        if (libro.getCopiasDisponibles() <= 0) throw new Exception("Libro no disponible");
        libro.prestar();
        usuario.agregarPrestamo(libro);
    }

    public void devolverLibro(String isbn, String idUsuario) throws Exception {
        Libro libro = buscarLibroISBN(isbn);
        Usuario usuario = buscarUsuarioID(idUsuario);
        if (libro == null || usuario == null) throw new Exception("Libro o usuario no encontrado");
        libro.devolver();
        usuario.devolverPrestamo(libro);
    }

    public Libro buscarLibroISBN(String isbn) {
        for (Libro l : libros) if (l.getIsbn().equals(isbn)) return l;
        return null;
    }

    public Usuario buscarUsuarioID(String id) {
        for (Usuario u : usuarios) if (u.getId().equals(id)) return u;
        return null;
    }

    public void mostrarLibros() {
        System.out.println("=== Libros en Biblioteca ===");
        for (Libro l : libros) System.out.println(l.mostrarInfo());
    }

    public void mostrarUsuarios() {
        System.out.println("=== Usuarios ===");
        for (Usuario u : usuarios) System.out.println(u.mostrarInfo());
    }
}
