package com.cultodeportivo.p1_arreglos.models;

public class Cliente {
    private String nombre;
    private int edad;
    private Mascota[] mascotas;

    public Cliente(String nombre, int edad, Mascota[] mascotas) {
        this.nombre = nombre;
        this.edad = edad;
        this.mascotas = mascotas;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public void agregarMascota(Mascota mascota) {
        Mascota[] mascotasNuevas = new Mascota[mascotas.length + 1];

        for (int i = 0; i < mascotas.length; i++) {
            mascotasNuevas[i] = mascotas[i];
        }

        mascotasNuevas[mascotas.length] = mascota;
        mascotas = mascotasNuevas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Mascota[] getMascotas() {
        return mascotas;
    }

    public void setMascotas(Mascota[] mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", mascotas=" + imprimirMascotas() +
                '}';
    }

    public String imprimirMascotas() {
        StringBuilder sb = new StringBuilder();
        for (Mascota mascota : mascotas) {
            sb.append(mascota).append("\n");
        }
        return sb.toString();
    }
}
