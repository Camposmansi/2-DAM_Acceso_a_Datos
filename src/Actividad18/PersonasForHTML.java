package Actividad18;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
    /*
     *      EJERCICIO 2.
     *        Hacer otro proyecto que también utilice un archivo XML con los datos que queráis y otro archivo XSL
     *        con la hoja de estilo para presentar los datos anteriores generando un archivo HTML usando el lenguaje JAVA.
     *        (a elección del estudiante)
     */
public class PersonasForHTML {
    public static void main(String[] args) throws IOException{
        String hojaEstilo = ".\\src\\Actividad18\\personasPlantilla.xsl";
        String datosAlumnos = ".\\src\\Actividad18\\Personas.xml";
        File pagHTML = new File(".\\src\\Actividad18\\mipaginaDePersonas.html");
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
