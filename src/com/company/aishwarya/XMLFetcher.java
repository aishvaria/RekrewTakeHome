package com.company.aishwarya;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

public class XMLFetcher {

    public String getXMLfromURL() throws ParserConfigurationException, IOException {
        URL url = new URL("http://www.bindows.net/documentation/download/ab.xml");
        URLConnection conn = null;
        try {
            conn = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = builder.parse(conn.getInputStream());
        } catch (SAXException e) {
            e.printStackTrace();
        }

        TransformerFactory transformerFactory= TransformerFactory.newInstance();
        Transformer xform = null;
        try {
            xform = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

// that’s the default xform; use a stylesheet to get a real one
        StringWriter writer = new StringWriter();
        try {
            xform.transform(new DOMSource(doc), new StreamResult(writer));
        } catch (TransformerException e) {
            e.printStackTrace();
        }


        String output = writer.getBuffer().toString().replaceAll("\n|\r", "");

        return output;
    }
}
