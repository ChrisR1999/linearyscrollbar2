package com.arturo.almaitu.Modelos;


public class ModeloDc {
    private String nombre;
    private String link;
    private String nombreImagen;
    private String descripcion;
    private String link2;
    private String descripcion2;
    private String link3;
    private String descripcion3;

    public ModeloDc() {

    }

    public ModeloDc(String nombre, String link, String nombreImagen, String descripcion, String link2, String descripcion2, String link3, String descripcion3) {
        this.nombre = nombre;
        this.link = link;
        this.nombreImagen = nombreImagen;
        this.descripcion = descripcion;
        this.link2 = link2;
        this.descripcion2 = descripcion2;
        this.link3 = link3;
        this.descripcion3 = descripcion3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public String getLink3() {
        return link3;
    }

    public void setLink3(String link3) {
        this.link3 = link3;
    }

    public String getDescripcion3() {
        return descripcion3;
    }

    public void setDescripcion3(String descripcion3) {
        this.descripcion3 = descripcion3;
    }
}

