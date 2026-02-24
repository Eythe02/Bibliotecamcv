import Controlador.GestorBiblioteca;
import Modelo.Libro;
import Modelo.Usuario;
import Modelo.Genero;
import Vista.Consola;

public class Main {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();

        Libro l1 = new Libro("111", "Java Básico", "Autor A", 2020, "Editorial1", Genero.NOVELA, 3);
        Libro l2 = new Libro("222", "Python Avanzado", "Autor B", 2021, "Editorial2", Genero.CIENCIA_FICCION, 2);

        Usuario u1 = new Usuario("U001", "Carlos");
        Usuario u2 = new Usuario("U002", "Ana");

        gestor.agregarLibro(l1);
        gestor.agregarLibro(l2);
        gestor.agregarUsuario(u1);
        gestor.agregarUsuario(u2);

        try {
            gestor.prestarLibro("111", "U001");
            gestor.prestarLibro("222", "U002");
        } catch (Exception e) {
            Consola.mostrarMensaje(e.getMessage());
        }

        gestor.mostrarLibros();
        gestor.mostrarUsuarios();
    }
}
