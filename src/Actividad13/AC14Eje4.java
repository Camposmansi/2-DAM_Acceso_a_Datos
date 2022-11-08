package Actividad13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;
            /*
             *      4.	BORRADO. Crea un programa Java (nombre del fichero: AC14Eje4.java) que al ejecutarlo desde
             *          la línea de comandos reciba un identificador de empleado y lo borre. Se hará un borrado
             *          lógico marcando el registro con la siguiente información: el identificador será igual a
             *          -1, el apellido será igual al identificador que se borra, y el departamento y salario serán 0.
             */
public class AC14Eje4 {
    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);

            File fichero = new File(".\\src\\Actividad13\\AleatorioEmple.dat");
            //declara el fichero de acceso aleatorio
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");

            //datos
            System.out.println("Introduce un Identificador:");
            int id = sc.nextInt();

            String apellido = String.valueOf(id); // apellido a insertar
            Double salario = 0.0; // salario
            int identificacion = -1; // id del empleado
            int dep = 0; // dep del empleado
            long posicion = (id - 1) * 36; //(4+20+4+8=36) la posicion

            if (posicion >= file.length()) {
                System.out.println("El empleado con ID: " + id + ", NO EXISTE...");
            } else {

                StringBuffer buffer = null; //buffer para almacenar apellido
                file.seek(posicion); // nos posicionamos
                file.writeInt(identificacion); // se escribe id
                buffer = new StringBuffer(apellido);
                buffer.setLength(10); // 10 caracteres para el apellido
                file.writeChars(buffer.toString());// insertar apellido
                file.writeInt(dep); // insertar departamento
                file.writeDouble(salario);// insertar salario
            }
            file.close(); // cerrar fichero
        }
        catch (FileNotFoundException fn ){
            System.err.println("\nNo se encuentra el fichero");
        }
        catch (IOException io) {
            System.err.println("\nError de E/S ");
        }
        catch (ArrayIndexOutOfBoundsException no) {
            System.err.println("\nNo tiene argumento");
        }
        catch (InputMismatchException e){
            System.err.println("\nTiene que escribir solo numeros");
        }
    }
}
