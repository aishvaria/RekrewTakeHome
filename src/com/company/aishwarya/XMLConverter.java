package com.company.aishwarya;

import org.json.JSONObject;
import org.json.XML;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLConverter {

    public String jsonToXML(JSONObject json){

        String jsonToXML = XML.toString(json);
        String formattedXml1 = prettyFormat(jsonToXML);
        return formattedXml1;
    }

    public static String prettyFormat (String input){
        return prettyFormat(input, "2");
    }

    public static String prettyFormat (String input, String indent){
        Source xmlInput = new StreamSource(new StringReader(input));
        StringWriter stringWriter = new StringWriter();
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", indent);
            transformer.transform(xmlInput, new StreamResult(stringWriter));

            String pretty = stringWriter.toString();
            pretty = pretty.replace("\r\n", "\n");
            return pretty;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
