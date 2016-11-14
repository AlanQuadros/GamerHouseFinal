/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author alan
 */
public class Util {

    public static final void modifyXML(String username){
        try {
            File filepath = new File("/home/alan/.snes9x/snes9x.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath.toString());

            Element traceElem = doc.getDocumentElement();
            Element elem = (Element) traceElem.getElementsByTagName( "option" ).item( 15 );

            elem.removeAttribute("value");
            elem.setAttribute("value", "/home/alan/Downloads/Players/"+username);

            System.out.println( elem.getAttribute( "name" ));
            System.out.println( elem.getAttribute( "value" ));

            filepath.delete();

            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/alan/.snes9x/snes9x.xml"));

            String resultado = getStringFromDocument(doc);

            writer.write(resultado);

            writer.close();

        } catch(Exception e){

        }
    }

    private static String getStringFromDocument(Document doc){
        try{
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString();
        }
        catch(TransformerException ex){
            ex.printStackTrace();
            return null;
        }
    }

}
