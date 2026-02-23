package Modelo;

import java.time.LocalDate;

public class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaVencimiento = fechaPrestamo.plusDays(30);
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaVencimiento);
    }

    public String mostrarInfo() {
        return libro.getTitulo() +
                " | Usuario: " + usuario.getNombre() +
                " | Prestado: " + fechaPrestamo +
                " | Vence: " + fechaVencimiento;
    }
}
