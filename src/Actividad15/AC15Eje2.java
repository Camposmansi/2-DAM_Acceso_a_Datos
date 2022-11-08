package Actividad15;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
        /*
         *      Lee el documento XML, creado en el apartado anterior.
         */
public class AC15Eje2 {
    public static void main(String argv[]) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(".\\src\\Actividad15\\Personas.xml"));
            document.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            //crea una lista con todos los nodos persona
            NodeList personas = document.getElementsByTagName("Persona");
            //recorrer la lista
            for (int i = 0; i < personas.getLength(); i ++) {

                Node persN = personas.item(i); //obtener un nodo

                if (persN.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
                    Element elemento = null;

                    elemento = (Element) persN;

                    System.out.println("DNI: " + getNodo("dni", elemento));
                    System.out.println("Nombre: " + getNodo("nombre", elemento));
                    System.out.println("Apellido: " + getNodo("apellido", elemento));
                    System.out.println("Edad: " + getNodo("edad", elemento));
                    System.out.println("Casado: " + getNodo("casado", elemento));
                    System.out.println("Telefono: " + getNodo("telefono", elemento));
                    System.out.println("Direccion: " + getNodo("direccion", elemento));
                }
            }
        } catch (Exception e) {e.printStackTrace();}
    }//fin de main
    //obtener la información de un nodo
    private static String getNodo(String etiqueta, Element elem)
    {
        NodeList nodo= elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();//devuelve el valor del nodo
    }
}//fin de la clase

