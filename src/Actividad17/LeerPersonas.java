package Actividad17;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;

    /*
     *      Hacer otra clase para hacer el proceso de lectura del fichero XML que se ha generado, utilizando también XStream.
     *      Nota: hay que meter en el proyecto la clase ListaPersonas y la clase Persona (que ya
     *      teníamos de ejercicios anteriores)
     */

public class LeerPersonas {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    try{
        Class<?>[] classes = new Class[]{ListaPersonas.class,Persona.class}; // Se dan Permisos a la clase

        XStream xstream = new XStream();

        xstream.allowTypes(classes); //Concedemos los permisos
        xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
        xstream.alias("DatosPersona", Persona.class);
        xstream.addImplicitCollection(ListaPersonas.class,"lista");
        ListaPersonas listadoTodas = (ListaPersonas)
                xstream.fromXML(new FileInputStream(".\\src\\Actividad17\\Personas.xml"));
        System.out.println("Numero de Personas: " + listadoTodas.getListaPersonas().size());
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas = listadoTodas.getListaPersonas();
        Iterator iterador = listaPersonas.listIterator();
        while( iterador.hasNext() ) {
            Persona p = (Persona) iterador.next();
            System.out.printf("Nombre: %s, edad: %d %n", p.getNombre(), p.getEdad());
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
        System.out.println("Fin de listado .....");
    } //fin main
}//fin LeerPersonas
