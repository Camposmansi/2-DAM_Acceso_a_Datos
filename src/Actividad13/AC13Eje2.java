package Actividad13;

import java.io.*;
import java.util.Scanner;

        /*
         *      2.	INSERCIÓN. Crea un programa Java (nombre del fichero: AC13Eje2.java) que inserte datos en
         *          el fichero aleatorio. El programa se ejecutará desde la línea de comandos y debe recibir 4
         *          parámetros: Identificador de empleado, apellido, departamento y salario. Antes de insertar
         *          se comprobará si el identificador existe, en ese caso se debe visualizar un mensaje indicándolo;
         *          si no existe se deberá insertar.
         */
public class AC13Eje2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        File fichero = new File(".\\src\\Actividad13\\AleatorioEmple.dat");
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        //int posicion;
        //arrays con los datos
        String apellido[] = {"CAMPOS"}; //apellidos
        int dep[] = {10}; //departamentos
        Double salario[]={2400.60};//salarios

        System.out.println ("Introduce un Identificador:");
        int id = sc.nextInt();

        long posicion = (id -1) * 36; //calculo donde empieza el registro
        if (posicion >= file.length()){
            System.out.println("ID: " + id + ", NO EXISTE EMPLEADO...");

            StringBuffer buffer = null; //buffer para almacenar apellido
            int n=apellido.length;//numero de elementos del array
            for (int i=0;i<n; i++) { //recorro los arrays
                file.seek(posicion); //nos posicionamos
                file.writeInt(id); //uso i+1 para identificar empleado
                buffer = new StringBuffer(apellido[i]);
                buffer.setLength(10); //10 caracteres para el apellido
                file.writeChars(buffer.toString());//insertar apellido
                file.writeInt(dep[i]); //insertar departamento
                file.writeDouble(salario[i]);//insertar salario
            }
            System.out.println("ID: " + id + ", Se añadio");
        }
        else {
            posicion = 0; //para situarnos al principio
            file.seek(posicion); // nos posicionamos
            id = file.readInt(); // obtengo id de empleado
            char apellidoSs[] = new char[10], aux;
            //obtener resto de los datos, como en el ejemplo anterior
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del apellido
                apellidoSs[i] = aux; //los voy guardando en el array
            }
            String apellidoS = new String(apellidoSs);//convierto a String el array
            int dep2=file.readInt();//obtengo dep
            Double salario2=file.readDouble(); //obtengo salario
            System.out.println("ID: " + id + ", Apellido: "+ apellidoS +
                    ", Departamento: "+dep + ", Salario: " + salario);
            posicion= posicion + 36; // me posiciono para el sig empleado
            //Cada empleado ocupa 36 bytes (4+20+4+8)
            //Si he recorrido todos los bytes salgo
        }
        file.close(); //cerrar fichero
    }
}
