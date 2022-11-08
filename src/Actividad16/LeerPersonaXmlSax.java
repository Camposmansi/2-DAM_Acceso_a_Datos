package Actividad16;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
    /*
     *    Utiliza SAX para visualizar el contenido del fichero Personas.xml creado anteriormente
     */
public class LeerPersonaXmlSax {
    public static void main(String[] args) throws IOException, SAXException {
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        GestionContenido gestor = new GestionContenido();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource(".\\src\\Actividad15\\Personas.xml");
        procesadorXML.parse(fileXML);
    }
}//fin PruebaSax1

class GestionContenido extends DefaultHandler {
    public GestionContenido() {
        super();
    }

    public void startDocument() {
        System.out.println("Comienzo del Documento XML");
    }

    public void endDocument() {
        System.out.println("Final del Documento XML");
    }

    public void startElement(String dni, String nombre,
                             String apellidos, int edad, boolean casado, int telefono, String direccion, Attributes atts) {
        System.out.printf("\tPrincipio Elemento: %s %n", nombre);
    }

    public void endElement(String dni, String nombre,
                           String apellidos, int edad, boolean casado, int telefono, String direccion) {
        System.out.printf("\tFin Elemento: %s %n", nombre);
    }

    public void characters(char[] ch, int inicio, int longitud)
            throws SAXException {
        String car = new String(ch, inicio, longitud);
        //quitar saltos de l�nea
        car = car.replaceAll("[\t\n]", "");
        System.out.printf("\tCaracteres: %s %n", car);
    }
}//fin GestionContenid