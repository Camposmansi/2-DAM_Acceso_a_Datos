package Actividad15;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
        /*
         *      A partir del fichero aleatorio de Personas (con al menos 5 registros) crea un documento XML usando DOM.
         */
public class AC15Eje1 {
    public static void main(String argv[]) throws IOException {
        File fichero = new File(".\\src\\Actividad15\\Personas.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int dni, edad, telefono;
        char nombre[] = new char[10], aux;
        char apellido[] = new char[10], aux2;
        char direccion[] = new char[30], aux3;
        boolean casado;
        int posicion = 0; //para situarnos al principio

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Personas", null);
            document.setXmlVersion("1.0"); // asignamos la version de nuestro XML

            for(;;) {
                file.seek(posicion); //nos posicionamos

                dni=file.readInt(); // obtengo id de empleado

                for (int j = 0; j < nombre.length; j++) {
                    aux = file.readChar();// recorro uno a uno los caracteres del nombre
                    nombre[j] = aux; // los voy guardando en el array
                }
                String nombreS = new String(nombre);// convierto a String el array

                for (int k = 0; k < apellido.length; k++) {
                    aux2 = file.readChar();// recorro uno a uno los caracteres del apellido
                    apellido[k] = aux2; // los voy guardando en el array
                }
                String apellidoS = new String(apellido);// convierto a String el array

                edad = file.readInt();// obtengo edad
                casado = file.readBoolean();
                telefono = file.readInt();


                for (int m = 0; m < direccion.length; m++) {
                    aux3 = file.readChar();// recorro uno a uno los caracteres del direccion
                    direccion[m] = aux3; // los voy guardando en el array
                }
                String direccionS = new String(direccion);// convierto a String el array
                LDNI letra = new LDNI(dni); //
                String l = String.valueOf(letra.obtenerLetra());
                {
                    Element raiz = document.createElement("Persona"); // nodo empleado
                    document.getDocumentElement().appendChild(raiz);

                    CrearElemento("dni", Integer.toString(dni) + l, raiz, document); // dni
                    CrearElemento("nombre", nombreS.trim(), raiz, document); // nombre
                    CrearElemento("apellido", apellidoS.trim(), raiz, document); // apellido
                    CrearElemento("edad", Integer.toString(edad), raiz, document); // edad
                    CrearElemento("casado", Boolean.toString(casado), raiz, document); // casado
                    CrearElemento("telefono", Integer.toString(telefono), raiz, document); // telefono
                    CrearElemento("direccion", direccionS.trim(), raiz, document); // direccion

                }
                posicion= posicion + 113; // me posiciono para el sig empleado (4 + 20 + 20 + 4 + 1 + 4 + 60 = 113)
                //Si he recorrido todos los bytes salgo del for
                if (file.getFilePointer() == file.length()) break;
            }//fin del for que recorre el fichero


            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(".\\src\\Actividad15\\Personas.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
        file.close(); //cerrar fichero
    }//fin de main
    //Inserción de los datos del empleado
    static void CrearElemento(String datoEmple, String valor,
                              Element raiz, Document document){
        Element elem = document.createElement(datoEmple); //creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}//fin de la clase

