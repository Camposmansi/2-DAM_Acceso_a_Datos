package Actividad12;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
        /*
         *    1.1.	Cambia el programa Java (nombre del fichero: AC12Eje1-1.java) para que el nombre del fichero se
         *          acepte al ejecutar el programa desde la línea de comandos.
         *
         *          Nota:
         *          Si no se ha introducido el nombre del fichero, que salga un mensaje informándolo.
         *          En el caso de que no exista el fichero, el programa tiene que lanzar una excepción
         *          con un mensaje de que no existe.
         */
public class AC12Eje1_1 {
    public static void main(String[] args) throws IOException {

        if (args.length == 0){
            System.out.println("\nNo tiene ningun argumento");
            }
        else {
            File fichero = new File(args[0]);
            if (!fichero.exists()) {
                System.out.println("\nFichero " + fichero.getName() + " no existe");
            } else {
                FileReader fic = new FileReader(fichero);
                System.out.println("\n" + fichero.getAbsoluteFile() + "\n");
                int i;
                while ((i = fic.read()) != -1) //se va leyendo un carácter
                    System.out.print((char) i);
                fic.close(); //cerrar fichero
                }
            }
    }

}
