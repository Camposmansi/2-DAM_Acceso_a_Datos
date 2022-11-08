package Actividad13;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Menu {
    public static void listadoOpciones() {
        System.out.println("1. Consulta");
        System.out.println("2. Insercion");
        System.out.println("3. Modificacion");
        System.out.println("4. Borrado");
        System.out.println("5. Elementos borrados");
        System.out.print("Introduce una opcion(0 para salir): ");
    }
    public static void insertar(RandomAccessFile file, Scanner sc, Scanner scad, int id) {
        try {
            StringBuffer buffer = null; // bufer para almacenar apellido
            System.out.print("Nuevo apellido: ");
            String apellido = scad.next(); // apellido a insertar
            System.out.print("Nuevo salario: ");
            Double salario = sc.nextDouble(); // salario
            System.out.print("Nuevo departamento: ");
            int dep = sc.nextInt(); // dep del empleado

            long posicion = (id - 1) * 36; // calculamos la posicion
            file.seek(posicion);
            file.writeInt(id); // se escribe id
            buffer = new StringBuffer(apellido);
            buffer.setLength(10); // 10 caracteres para el apellido
            file.writeChars(buffer.toString());// insertar apellido
            file.writeInt(dep); // insertar departamento
            file.writeDouble(salario);// insertar salario
            posicion = posicion + 36;
//			file.close(); // cerrar fichero

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se puede sobreescribir.");
        }

    }
    public static void consultarEInsertar(RandomAccessFile file, Scanner sc, Scanner scad)
            throws IOException {

        int id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        posicion = 0;
        System.out.print("ID necesario:");
        int identificador = sc.nextInt();
        posicion = (identificador - 1) * 36;

        if (posicion >= file.length()) {
            System.out.println("ID nuevo: " + identificador);
            insertar(file,sc,scad,identificador);
        }else {
            file.seek(posicion); // nos posicionamos en posicion
            id = file.readInt(); // obtengo id de empleado
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();// recorro uno a uno los caracteres del apellido
                apellido[i] = aux; // los voy guardando en el array
            }
            String apellidoS = new String(apellido);// convierto a String el array
            dep = file.readInt();// obtengo dep
            salario = file.readDouble(); // obtengo salario

            System.out.println(
                    "ID: " + id + ", Apellido: " + apellidoS + ", Departamento: " + dep + ", Salario: " + salario);
//			posicion = posicion + 36; // me posiciono para el sig empleado
            if(id == 0) {
                insertar(file,sc,scad,identificador);
            }else System.out.println("Ya existe!");
        }


    }
    public static void consultar(RandomAccessFile file, Scanner sc)
            throws IOException, EOFException {

        int id, dep, posicion = 0;
        Double salario;
        char apellido[] = new char[10], aux;
        System.out.print("ID necesario:");
        int identificador = sc.nextInt();
        posicion = (identificador - 1) * 36; // calculo donde empieza el registro

        if (posicion >= file.length())
            System.out.println("ID: " + identificador + ", NO EXISTE EMPLEADO...");
        else {

            file.seek(posicion); // nos posicionamos en posicion
            id = file.readInt(); // obtengo id de empleado
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();// recorro uno a uno los caracteres del apellido
                apellido[i] = aux; // los voy guardando en el array
            }
            String apellidoS = new String(apellido);// convierto a String el array
            dep = file.readInt();// obtengo dep
            salario = file.readDouble(); // obtengo salario

            System.out.println(
                    "ID: " + id + ", Apellido: " + apellidoS + ", Departamento: " + dep + ", Salario: " + salario);
            posicion = posicion + 36; // me posiciono para el sig empleado
            // Cada empleado ocupa 36 bytes (4+20+4+8)
            // Si he recorrido todos los bytes salgo del for
        }

    }
    public static void modificar(RandomAccessFile file, int identificacion, double nuevoSalario) throws IOException {

        double salario;
        double aux;
        long posicionAux;
        long posicion = (identificacion - 1) * 36; // (4+20+4+8) modifico salario y dep
        posicion = posicion + 4 + 20+4; // sumo el tama�o de ID+apellido
        posicionAux = posicion;
        file.seek(posicion); // nos posicionamos
        salario = file.readDouble(); // obtengo salario
        aux = (double) salario;
        salario += nuevoSalario;
        file.seek(posicionAux); // nos posicionamos
        file.writeDouble((double) salario);// modif salario
        System.out.println("ID:" + identificacion);
        System.out.println("Nuevo salario: " + salario);
        System.out.println("Antiguo salario: " +(double) aux);
    }
    public static void borrar(RandomAccessFile file, File f1,int identificacion) throws IOException {
        crearBorrados(f1, identificacion);
        StringBuffer buffer = null; // bufer para almacenar apellido
        String apellido = "-1"; // apellido a insertar
        Double salario = 0.0; // salario
        int id = -1; // id del empleado
        int dep = 0; // dep del empleado
        long posicion = (identificacion - 1) * 36; // calculamos la posicion
        file.seek(posicion); // nos posicionamos
        file.writeInt(id); // se escribe id
        buffer = new StringBuffer(apellido);
        buffer.setLength(10); // 10 caracteres para el apellido
        file.writeChars(buffer.toString());// insertar apellido
        file.writeInt(dep); // insertar departamento
        file.writeDouble(salario);// insertar salario

    }
    public static void crearBorrados(File file2, int id) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(file2,true);
            pw = new PrintWriter(fw);
            pw.println("ID: "+id);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void leerBorrados(File file2) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file2);
            br = new BufferedReader(fr);
            String line ="";
            while((line=br.readLine())!=null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scad = new Scanner(System.in);
        File fichero = new File(".\\src\\Actividad13\\AleatorioEmple.dat");
        File borrados = new File(".\\src\\Actividad13\\Borrados.txt");
        RandomAccessFile file;
        try {
            file = new RandomAccessFile(fichero, "rw");
            // declara el fichero de acceso aleatorio

            int op;
            do {
                listadoOpciones();
                op = sc.nextInt();
                if (op == 1) {//consultar
                    consultar(file,sc);
                    //sigo mostrando valor vacios
                } else if (op == 2) {//consultar e insertar
                    consultarEInsertar(file,sc,scad);
                    //de momento no sobreescribe en otro id
                    //sobreescribe en id = 0
                } else if (op == 3) {
                    //modificar
                    System.out.print("ID necesario: ");
                    int identificador = sc.nextInt();
                    System.out.println("Nuevo salario: ");
                    double nuevoSalario = sc.nextDouble();
                    modificar(file, identificador, nuevoSalario);
                }else if (op == 4) {
                    System.out.print("ID necesario: ");
                    int identificador = sc.nextInt();
                    borrar(file, borrados, identificador);

                }else if(op==5) {
                    leerBorrados(borrados);
                }
            } while (op != 0);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se puede");
        }
        sc.close();
    }
}
