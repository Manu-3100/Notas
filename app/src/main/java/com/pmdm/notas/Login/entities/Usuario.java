package com.pmdm.notas.Login.entities;

public class Usuario {

    private String nome;
    private String contrasinal;

    public Usuario(String nome, String contrasinal) {
        this.nome = nome;
        this.contrasinal = contrasinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContrasinal() {
        return contrasinal;
    }

    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }
}
