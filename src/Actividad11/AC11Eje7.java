package Actividad11;

import java.io.File;
    /*   7)	Realiza un programa Java (nombre del fichero: AC11Eje7.java)
     *       que utilice el método listFile() para mostrar la lista de ficheros
     *       en un directorio cualquiera, o en el directorio actual.
     */
public class AC11Eje7 {
    public static void main(String[] args) {
        File f = new File("c:\\users");
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
