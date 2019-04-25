package com.example.alumno.clasetres;

public class Carrusel {
    private Number idCarrusel;
    private String titulo;
    private String subtitulo;
    private String orden;
    private String tipo_carrusel;
    private String foto;

    public Carrusel(Number idCarrusel, String titulo, String subtitulo, String orden, String tipo_carrusel, String foto) {
        this.idCarrusel = idCarrusel;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.orden = orden;
        this.tipo_carrusel = tipo_carrusel;
        this.foto = foto;
    }

    public Number getIdCarrusel() {
        return idCarrusel;
    }

    public void setIdCarrusel(Number idCarrusel) {
        this.idCarrusel = idCarrusel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getTipo_carrusel() {
        return tipo_carrusel;
    }

    public void setTipo_carrusel(String tipo_carrusel) {
        this.tipo_carrusel = tipo_carrusel;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Carrusel{" +
                "idCarrusel=" + idCarrusel +
                ", titulo='" + titulo + '\'' +
                ", subtitulo='" + subtitulo + '\'' +
                ", orden='" + orden + '\'' +
                ", tipo_carrusel='" + tipo_carrusel + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
