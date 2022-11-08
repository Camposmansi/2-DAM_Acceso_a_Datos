package Actividad12;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
        /*
         *   1.	Crea un fichero de texto con algún editor de textos y después realiza un programa Java
         *      (nombre del fichero: AC12Eje1.java) que visualice su contenido.
         */
public class AC12Eje1 {
    public static void main(String[] args) throws IOException {
        //declarar fichero
        File fichero = new File("FichTexto.txt");
        //crear el flujo de entrada hacia el fichero
        FileReader fic = new FileReader(fichero);
        int i;
        while ((i = fic.read()) != -1) //se va leyendo un carácter
            System.out.print((char) i);
        fic.close(); //cerrar fichero
    }

}
