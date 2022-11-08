package Actividad11;

import java.io.File;
        /*
         *   11)	Realizar un programa Java (nombre del fichero: AC11Eje12.java) que muestre el contenido del
         *          directorio raíz de la unidad actual de trabajo y de todos sus subdirectorios de forma recursiva.
         *          Para cada directorio se muestran primero los archivos y a continuación las carpetas que contienen
         *          de forma recursiva.
         */
public class AC11Eje12 {
    public static void main(String[] args) {
        recorrerDirectorios(".");
    }

    public static void recorrerDirectorios(String ruta) {
        //Se crea un objeto file con la ruta del directorio
        File directorio = new File(ruta);
        //Se comprueba si la ruta existe
        if (!directorio.exists()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no existe.");
            return;
        }
        //Se comprueba si es un directorio
        if (!directorio.isDirectory()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no es un directorio");
            return;
        }
        System.out.println(directorio.getAbsolutePath());
        //obtener todo el contenido del directorio
        File[] lista = directorio.listFiles();
        //se recorre el directorio y se muestran primero los archivos
        for (File s : lista) {
            if (s.isFile())
                System.out.println("Archivo ->  " + s.getName());
        }
        //se recorre de nuevo el directorio y se obtiene los subdirectorios
        for (File s : lista) {
            //Si es un directorio se vuelve a llamar al método
            if (s.isDirectory()) {
                recorrerDirectorios(s.getAbsolutePath());
            }
        }
    }
}
