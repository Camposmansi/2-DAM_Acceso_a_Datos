    import java.io.*;
    public class EscribirFichTexto {
        public static void main(String[] args) throws IOException {
            File fichero = new
                    File("FichTexto.txt");//declarar fichero
            //crear flujo de salida
            FileWriter fic = new FileWriter(fichero, true);
            /*  String cadena ="Esto es una prueba con FileWriter";
            convierte la cadena en array de caracteres para extraerlos 1 a 1
            char[] cad = cadena.toCharArray();
            for(int i=0; i<cad.length; i++)
                fic.write(cad[i]); //se va escribiendo un carácter
            */
            String prov[] =
                    {"Albacete","Avila","Badajoz","Cáceres","Huelva","Jaén",
                            "Madrid","Segovia","Soria","Toledo","Valladolid","Zamora"};
            for(int i=0; i<prov.length; i++) fic.write(prov[i]+"\n");

            fic.append("*\n"); //se añade al final un *
            fic.close(); //cerrar fichero
        }
    }



