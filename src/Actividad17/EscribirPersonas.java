package Actividad17;

import java.io.*;
import com.thoughtworks.xstream.XStream;

    /*
     *   1) Hacer el ejercicio de ejemplo de la teoría de la parte 6 (TRABAJO CON FICHEROS XML). Viene a partir de la página 11.
     *      Utilizaremos para ello la librería XStream.
     *      Se utilizará el fichero FichPersona.dat para crear una lista de personas que hay que
     *      insertar en un fichero Personas.xml (Hay que hacer la clase para para EscribirPersonas)
     */
public class EscribirPersonas {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       /*
        File fichero = new File("FichPersona.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        System.out.println("Comienza el proceso...");
        //Creamos un objeto Lista de Personas
        ListaPersonas listaper = new ListaPersonas();
        try {
            while (true) { //lectura del fichero
                Persona persona= (Persona) dataIS.readObject();
                listaper.add(persona); //añadir persona a la lista
            }
        } catch (EOFException eo) {}
        dataIS.close(); //cerrar stream de entrada
        */


        ListaPersonas listaperr;
        listaperr=new ListaPersonas();
        listaperr.add(new Persona("CCarlos",5));
        listaperr.add(new Persona("fgsd",25));
        listaperr.add(new Persona("sdfgs",35));
        listaperr.add(new Persona("CCgsdfgarlos",51));
        listaperr.add(new Persona("CCarlos",50));

        try {
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
            xstream.alias("DatosPersona", Persona.class);
            //quitar etiqueta lista (atributo de la clase ListaPersonas)
            xstream.addImplicitCollection(ListaPersonas.class, "lista");
            //Insertar los objetos en el XML
            xstream.toXML(listaperr,new FileOutputStream(".\\src\\Actividad17\\Personas.xml"));
            System.out.println("Creado fichero XML....");
        }catch (Exception e)
        {e.printStackTrace();}
    } // fin main
} //fin EscribirPersonas
