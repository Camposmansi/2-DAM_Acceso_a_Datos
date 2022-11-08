package Actividad13;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
        /*
         *     4.1.	A continuación, has otro programa Java (o crea un método dentro del anterior programa)
         *          que muestre los identificadores de los empleados borrados (nombre del fichero: AC14Eje4-1.java).
         */
public class AC14Eje41 {
    public static void main(String[] args) throws IOException {

        File fichero = new File(".\\src\\Actividad13\\AleatorioEmple.dat");
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int  id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        posicion=0;  //para situarnos al principio

        for(;;){  //recorro el fichero
            file.seek(posicion); //nos posicionamos en posicion
            id=file.readInt();   // obtengo id de empleado
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del apellido
                apellido[i] = aux;    //los voy guardando en el array
            }
            String apellidoS= new String(apellido);//convierto a String el array
            dep=file.readInt();//obtengo dep
            salario=file.readDouble();  //obtengo salario

            if(id == -1) {
                System.out.println("ID: "+  apellidoS);
            }

            posicion= posicion + 36; // me posiciono para el sig empleado
            //Cada empleado ocupa 36 bytes (4+20+4+8=36)


            if (file.getFilePointer()==file.length())break; //Si he recorrido todos los bytes salgo del for

        }//fin bucle for


        file.close();  //cerrar fichero
    }
}
