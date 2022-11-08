package Actividad15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFichPerson {
        public static void main(String[] args) throws IOException {
            File fichero = new File(".\\src\\Actividad15\\Personas.dat");
            //declara el fichero de acceso aleatorio
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");
            //arrays con los datos
            int dni[] = {41234564, 98765432, 34562845, 27485678, 12345987}; //
            String nombre[] = {"ANA","OLGA","MARIA","RAQUEL","INMA"}; // Nombre
            String apellido[] = {"FERNANDEZ","GIL","LOPEZ","RAMOS","SEVILLA"}; //apellidos
            int edad[] = {56, 48, 30, 37, 39}; //
            boolean casado[] = {true, true, false, false, true}; //
            int tel[] = {911234101, 911234102, 911234103, 911234104, 911234105}; //departamentos
            String direccion[] = {"CALLE UNO","CALLE DOS","CALLE TRES","CALLE CUATRO","CALLE CINCO"}; // Nombre

            // 4 + 20 + 20 + 4 + 1 + 4 + 60 = 113

            /* Longitud de los tipos primitivos de datos
             *   int (4 bytes)
             *   short y String (2 bytes)
             *   byte y Boolean (1 byte)
             *   long (8 bytes)
             *   char (2 bytes)
             *   float (4 bytes)
             *   double (8 bytes)
            */


            StringBuffer buffer = null;// buffer para almacenar nombre/apellido
            int n=nombre.length;    // numero de elementos del array
            int a=apellido.length;  // numero de elementos del array
            int d=direccion.length; // numero de elementos del array

            for (int i=0;i<n; i++){ //recorro los arrays
                //file.writeInt(i+1); //uso i+1 para identificar empleado

                file.writeInt(dni[i]);

                // NOMBRE
                buffer = new StringBuffer(nombre[i] );
                buffer.setLength(10); //10 caracteres para el nombre
                file.writeChars(buffer.toString());// insertar nombre

                //APELLIDO
                buffer = new StringBuffer(apellido[i] );
                buffer.setLength(10); //10 caracteres para el apellido
                file.writeChars(buffer.toString());// insertar apellido

                file.writeInt(edad[i]);
                file.writeBoolean(casado[i]);
                file.writeInt(tel[i]);

                //DIRECCION
                buffer = new StringBuffer(direccion[i] );
                buffer.setLength(30); //30 caracteres para el direccin * 2 para el calculo
                file.writeChars(buffer.toString());// insertar direccion


            }
            file.close(); //cerrar fichero
        }
}
