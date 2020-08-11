package com.example.myapplication;

public class Mascota {
private String nombre;
private int votos,img,fotos[];

    public int getFotos(int ind) {
        return fotos[ind];
    }

    public void setFotos(int[] fotos) {
        this.fotos = fotos;
    }

    public Mascota(String nombre, int votos, int img) {
        this.nombre = nombre;
        this.votos = votos;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
