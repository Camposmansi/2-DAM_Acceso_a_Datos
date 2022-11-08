package Serializable;

import java.io.*;
public class EscribirFichObject {
    public static void main(String[] args) throws IOException {
        Persona persona; //defino variable Serializable.Persona

        // declara el fichero
        File fichero = new File(".\\src\\Serializable\\FichPersona.dat");

        //FileOutputStream fileout = new FileOutputStream(fichero);  // Lo cambiamos por el IF / ELSE

        ObjectOutputStream dataOS ;//= new ObjectOutputStream(fileout);

//      String nombres[] = {"Ana","Luis Miguel", "Alicia", "Pedro",
//                          "Manuel", "Andrés", "Julio", "Antonio", "María Jesús"};
//      int edades[] = {14,15,13,15,16,12,16,14,13};
        String nombres[] = {"Felix", "Pepe"};
        int edades[] = {20, 23};

            if (!fichero.exists()) //Si el fichero no existe crea una cabecera, la primera vez
            {
                FileOutputStream fileout;
                fileout = new FileOutputStream(fichero);
                dataOS = new ObjectOutputStream(fileout);
            }
            else  // Si ya existe el fichero usa MiObject... para no crear una cabecera
            {
                 dataOS = new MiObjectOutputStream
                    (new FileOutputStream(fichero,true));
            }

        for (int i=0;i<edades.length; i++) { //recorro los arrays
               persona = new Persona(nombres[i], edades[i]);
               dataOS.writeObject(persona); //escribo la Serializable.Persona en el fichero
        }
        dataOS.close(); //cerrar stream de salida
    }
}