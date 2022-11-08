package Actividad18;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

    /*
     *      EJERCICIO 1. (OPTATIVO)
     *                  Hacer el ejercicio de ejemplo de la teoría de la parte 6 (TRABAJO CON FICHEROS XML).
     *                  Viene a partir de la página 14.
     *                  Nota: hay que meter en el proyecto los archivos XML y XSL.
     */
public class convertidor {
    public static void main(String[] args) throws IOException{
        String hojaEstilo = ".\\src\\Actividad18\\alumnosPlantilla.xsl";
        String datosAlumnos = ".\\src\\Actividad18\\alumnos.xml";
        File pagHTML = new File(".\\src\\Actividad18\\mipagina.html");
        //crear fichero HTML
        FileOutputStream os = new FileOutputStream(pagHTML);
        Source estilos = new StreamSource(hojaEstilo); //fuente XSL
        Source datos = new StreamSource(datosAlumnos); //fuente XML
        //resultado de la transformación
        Result result = new StreamResult(os);
        try{
            Transformer transformer =
                    TransformerFactory.newInstance().newTransformer(estilos);
            transformer.transform(datos, result); //obtiene el HTML
        }
        catch(Exception e){System.err.println("Error: "+e);}
        os.close(); //cerrar fichero
    }//de main
}//de la clase
