package com.pmdm.notas.NotasAdapter.Entities;

public class Nota {
    private String titulo;
    private String data;
    private String modulo;
    private String imaxe;

    public Nota(String titulo, String data, String modulo) {
        this.titulo = titulo;
        this.data = data;
        this.modulo = modulo;
    }

    public Nota(String titulo, String imaxe, String modulo, String data) {
        this.titulo = titulo;
        this.imaxe = imaxe;
        this.modulo = modulo;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getImaxe() {
        return imaxe;
    }

    public void setImaxe(String imaxe) {
        this.imaxe = imaxe;
    }

}
