package Actividad15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File(".\\src\\Actividad15\\Personas.dat");
            //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int dni, edad, tel;
        char nombre[] = new char[10], aux;
        char apellido[] = new char[10], aux2;
        char direccion[] = new char[30], aux3;
        boolean casado;
        int posicion = 0; //para situarnos al principio

        for(;;){ //recorro el fichero
            file.seek(posicion); //nos posicionamos en posicion
            dni=file.readInt(); // obtengo id de empleado

            for (int i = 0; i < nombre.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del apellido
                nombre[i] = aux; //los voy guardando en el array
            }
            String nombreS= new String(nombre);//convierto a String el array

            for (int i = 0; i < apellido.length; i++) {
                aux2 = file.readChar();//recorro uno a uno los caracteres del apellido
                apellido[i] = aux2; //los voy guardando en el array
            }
            String apellidoS= new String(apellido); // convierto a String el array

            edad=file.readInt(); // obtengo la Edad
            casado= file.readBoolean();
            tel= file.readInt();

            for (int i = 0; i < direccion.length; i++) {
                aux3 = file.readChar();//recorro uno a uno los caracteres del apellido
                direccion[i] = aux3; //los voy guardando en el array
            }
            String direccionS= new String(direccion); // convierto a String el array
            LDNI letra = new LDNI(dni);
            String l = String.valueOf(letra.obtenerLetra());

            System.out.println("LDNI: " + dni + l + ", Nombre: "+ nombreS + ", Apellido: "+ apellidoS +
                    ", Edad: " + edad + ", Casado: " + casado + ", Telefono: " + tel + ", Direccion: " + direccionS);
            posicion= posicion + 113; // me posiciono para el sig empleado
            //Cada empleado ocupa 36 bytes (4+20+4+8)
            //Si he recorrido todos los bytes salgo del for
            if (file.getFilePointer()==file.length())break;
        }//fin bucle for
        file.close(); //cerrar fichero
    }
}
