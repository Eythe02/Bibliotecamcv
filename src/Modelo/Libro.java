package Modelo;

public class Libro {
    public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    private String editorial;
    private Genero genero;
    private int totalCopias;
    private int copiasDisponibles;
    private EstadoLibro estado;

    public Libro(String isbn, String titulo, String autor, int anio, String editorial,
                 Genero genero, int totalCopias) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.editorial = editorial;
        this.genero = genero;
        this.totalCopias = totalCopias;
        this.copiasDisponibles = totalCopias;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public EstadoLibro getEstado() { return estado; }
    public int getCopiasDisponibles() { return copiasDisponibles; }

    public void prestar() throws Exception {
        if (copiasDisponibles <= 0) throw new Exception("Libro no disponible");
        copiasDisponibles--;
        estado = copiasDisponibles == 0 ? EstadoLibro.PRESTADO : EstadoLibro.DISPONIBLE;
    }

    public void devolver() {
        copiasDisponibles++;
        estado = EstadoLibro.DISPONIBLE;
    }

    public String mostrarInfo() {
        return titulo + " (" + isbn + ") - " + estado + " - Copias: " + copiasDisponibles + "/" + totalCopias;
    }
}

}
