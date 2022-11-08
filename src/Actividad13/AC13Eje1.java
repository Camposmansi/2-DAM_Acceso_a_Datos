package Actividad13;

import java.io.*;
import java.util.Scanner;
        /*
         *   1.	CONSULTA. Crea un programa Java (nombre del fichero: AC13Eje1.java) que consulte los datos de
         *      un empleado del fichero aleatorio. El programa se ejecutará desde la línea de comandos y debe
         *      recibir un identificador de empleado. Si el empleado existe se visualizarán sus datos, si no
         *      existe se visualizará un mensaje indicándolo.
         */
public class AC13Eje1 {
    public static void main(String[] args) throws IOException{
        File fichero = new File(".\\src\\Actividad13\\AleatorioEmple.dat");
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        posicion = 0; //para situarnos al principio
        Scanner sc = new Scanner(System.in);
        System.out.println ("Introduce un Identificador:");
        int identificador = sc.nextInt();

        posicion = (identificador - 1) * 36; //calculo donde empieza el registro
        if (posicion >= file.length())
            System.out.println("ID: " + identificador + ", NO EXISTE EMPLEADO...");
        else {
            file.seek(posicion); // nos posicionamos
            id = file.readInt(); // obtengo id de empleado
            //obtener resto de los datos, como en el ejemplo anterior
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del apellido
                apellido[i] = aux; //los voy guardando en el array
            }
            String apellidoS= new String(apellido); //convierto a String el array
            dep=file.readInt(); //obtengo departamento
            salario=file.readDouble(); //obtengo salario
            System.out.println("ID: " + id + ", Apellido: " + apellidoS +
                    ", Departamento: " + dep + ", Salario: " + salario);
            posicion= posicion + 36; // me posiciono para el sig empleado
            //Cada empleado ocupa 36 bytes (4+20+4+8)
            //Si he recorrido todos los bytes salgo
        }
        file.close(); //cerrar fichero

    }

}
