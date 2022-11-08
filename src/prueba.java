import java.io.File;
import java.io.IOException;

public class prueba {
    public static void main(String[] args) throws IOException {
        File ruta = new File("c:/ficheros");
        File f = new File(ruta, "datos.txt");

        if (!f.exists()) {  //se comprueba si el fichero existe o no
            System.out.println("Fichero " + f.getName() + " no existe");

        } else { //el fichero existe. Mostramos el tamaño
            System.out.println("Fichero " + f.getName() + " existe");
            System.out.println("Tamaño " + f.length() + " bytes");
        }
    }
}

