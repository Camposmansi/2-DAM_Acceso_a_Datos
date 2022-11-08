
    import java.io.*;
    public class LeerFichTexto {
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


