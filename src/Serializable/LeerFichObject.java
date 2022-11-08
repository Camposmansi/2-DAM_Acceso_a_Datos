package Serializable;

import java.io.*;
public class LeerFichObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Persona persona; //defino la variable Persona

        File fichero = new File(".\\src\\Serializable\\FichPersona.dat");
          //crea el flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);
            //conecta el flujo de bytes al flujo de datos
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        try {
            while (true) { //lectura del fichero
                persona= (Persona) dataIS.readObject(); //leer una Serializable.Persona
                System.out.printf(persona.toString());
            }
        }catch (EOFException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        dataIS.close(); //cerrar stream de entrada
    }
}