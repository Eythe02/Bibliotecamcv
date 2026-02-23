import java.util.List;

public class Consola {

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarLibros(List<Libro> libros) {
        System.out.println("Libros:");
        for (Libro l : libros) {
            System.out.println(l.mostrarInfo());
        }
    }

    public static void mostrarUsuarios(List<Usuario> usuarios) {
        System.out.println("Usuarios:");
        for (Usuario u : usuarios) {
            System.out.println(u.mostrarInfo());
        }
    }
}
