package com.example.alumno.clasetres;

/**
 * Created by alumno on 04/04/2019.
 */

public class Persona {

    private String nombre;
    private String apellido;
    private String telefono;
    private String imagen;
    private byte[] imagenes;
    public Boolean seEstaDescargando = Boolean.FALSE;
    public Persona() {

    }


    public Persona(String nombre, String apellido, String telefono, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(byte[] imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
