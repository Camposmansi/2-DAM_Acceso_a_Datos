package Actividad11;

import java.io.File;
        /*
         *   8)	Realizar un programa Java (nombre del fichero: AC11Eje8.java) que muestre los ficheros de un directorio.
         *      EL nombre del directorio se pasará al programa desde los argumentos main(). Si el directorio no existe
         *      se debe mostrar un mensaje indicándolo.
         */
public class AC11Eje8 {
    public static void main(String[] args) {
        File f = new File(args[0]);
        File[] ficheros = f.listFiles();

        if (ficheros == null)
            System.out.println("No hay ficheros en el directorio especificado");
        else {
            for (int x = 0; x < ficheros.length; x++) {
                System.out.println(ficheros[x].getName());
            }
        }
    }
}
