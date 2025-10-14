package com.cultodeportivo.entornosistema;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EjemploAsignarPropiedadesDeSistema {

    public static void main(String[] args) {
        try {
            FileInputStream archivo = new FileInputStream("Java Master/p01_basicos/src/main/resources/config.properties");

            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada", "Mi valor guardado en el objeto properties");
            System.setProperties(p);

            Properties ps = System.getProperties();
            System.out.println("ps.getProperty(...) = " + ps.getProperty("mi.propiedad.personalizada"));
            System.out.println(System.getProperty("config.puerto.servidor"));
            System.out.println(System.getProperty("config.autor.nombre"));
            System.out.println(System.getProperty("config.autor.email"));

        } catch (IOException e) {
            System.err.println("no existe el archivo = " + e);
            System.exit(1);
        }
    }
}
