package com.cultodeportivo.p1_arreglos;

import com.cultodeportivo.p1_arreglos.models.Cliente;
import com.cultodeportivo.p1_arreglos.models.Mascota;

public class EjemploArreglos3 {
    public static void main(String[] args) {
        Mascota mascota = new Mascota("Firulais", 2);
        Mascota mascota2 = new Mascota("Bruno", 2);
        Mascota mascota3 = new Mascota("Luna", 2);

        Mascota[] mascotas = {mascota, mascota2, mascota3};
        
        Cliente cliente = new Cliente("Juan", 20, mascotas);
        System.out.println(cliente);

        cliente.agregarMascota(new Mascota("Pepito", 2));
        System.out.println(cliente);

        cliente.agregarMascota(new Mascota("Cirilio", 2));
        cliente.agregarMascota(new Mascota("Actros", 2));
        cliente.agregarMascota(new Mascota("Perla", 2));
        System.out.println(cliente);


      
    }
}
