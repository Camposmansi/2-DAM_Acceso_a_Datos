package Actividad11;

import java.io.File;
import java.util.Scanner;
        /*
         *   10)	Realizar un programa Java (nombre del fichero: AC11Eje10.java) que elimine un fichero y cambie
         *          el nombre de un fichero usando la clase File.
         */
public class AC11Eje10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;

        //Eliminar un fichero
        System.out.println("Introduce el nombre del fichero a eliminar: ");
        nombre = sc.nextLine();
        File f = new File(nombre);
        if(f.exists()){
            System.out.println(f.getAbsolutePath());
            if(f.delete()){
                System.out.println("Fichero eliminado");
            }  else{
                System.out.println("No se ha podido eliminar");
            }
        }  else{
            System.out.println("El fichero " + f.getAbsolutePath() + " no existe");
        }

        //Cambiar el nombre de un fichero
        String nuevoNombre;
        System.out.println("Introduce el nombre del fichero a renombrar: ");
        nombre = sc.nextLine();
        File f1 = new File(nombre);
        if(f1.exists()){
            System.out.println(f1.getAbsolutePath());
            System.out.println("Introduce nuevo nombre: ");
            nuevoNombre = sc.nextLine();
            File f2 = new File(nuevoNombre);
            if(f1.renameTo(f2)){
                System.out.println("Se ha cambiado el nombre");
            }  else{
                System.out.println("No se ha podido cambiar el nombre");
            }
        }  else{
            System.out.println("El fichero " + f1.getAbsolutePath() + " no existe");
        }
    }
}
