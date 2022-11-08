package Actividad13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

    /*  3.	MODIFICACIÓN. Crea un programa Java (nombre del fichero: AC14Eje3.java) que reciba desde la línea de comandos
     *      un identificados de empleado y un importe. Se debe realizar la modificación del salario.
     *      La modificación consistirá en sumar al salario del empleado el importe introducido.
     *      El programa debe visualizar el apellido, el salario antiguo y el nuevo. Si el identificador
     *      no existe se visualizará un mensaje indicándolo.
     */
public class AC14Eje3 {
    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);

            File fichero = new File(".\\src\\Actividad13\\AleatorioEmple.dat");
            //declara el fichero de acceso aleatorio
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");

            //datos
            int dep; //departamentos

            System.out.println("Introduce un Identificador:");
            int id = sc.nextInt();

            long posicion = (id - 1) * 36; //(4+20+4+8) la posicion


            if (posicion >= file.length()) {
                System.out.println("El empleado con ID: " + id + ", NO EXISTE...");
            } else {
                file.seek(posicion); // nos posicionamos
                id = file.readInt(); // obtengo id de empleado
                if (id == -1 || id == 0) {
                    System.out.println("El empleado NO EXISTE...");
                } else {
                    System.out.println("Introduce una Subida de sueldo:");
                    Double salario = sc.nextDouble();//salario
                    //file.writeInt(id); // cambio id de empleado
                    //Capturamos el Apellido
                    char apellido[] = new char[10], aux;
                    for (int i = 0; i < apellido.length; i++) {
                        aux = file.readChar();//recorro uno a uno los caracteres del apellido
                        apellido[i] = aux; //los voy guardando en el array
                    }
                    String apellidoS = new String(apellido); // convierto a String el array

                    //dep = file.readInt(); // obtengo departamento
                    //posicion = posicion + 4 + 20 + 4; //sumo el tamaño de ID+Apellido+Departamento
                    file.seek(posicion + 28); //Y nos posicionamos

                    Double salarioOld = file.readDouble(); //obtengo salario
                    Double sumaSal = (salarioOld + salario); //Sumo salarios

                    //Modifico el Salario
                    //posicion = posicion + 4 + 20 + 4; //sumo el tamaño de ID+Apellido+Departamento
                    file.seek(posicion + 28); //Y nos posicionamos
                    file.writeDouble(sumaSal);//Modifico el salario

                    //Mostramos los datos requeridos
                    System.out.println("Apellidos: " + apellidoS + " Salario Antiguo: " + salarioOld + " Salario Nuevo: " + sumaSal);
                }
            }
            file.close(); //cerrar fichero
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
