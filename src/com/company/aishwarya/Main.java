package com.company.aishwarya;

import org.json.JSONObject;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        System.out.println("Fetching XML from URL");
        XMLFetcher xmlFetcher = new XMLFetcher();

        String xml = null;
        try {
            xml = xmlFetcher.getXMLfromURL();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Converting XML TO JSON");

            JSONConverter jsonConverter = new JSONConverter();

            JSONObject json = jsonConverter.convertXMLToJSON(xml);

        System.out.println("Converting JSON TO xml");

            XMLConverter XMLConverter = new XMLConverter();

            String xmlResult = XMLConverter.jsonToXML(json);

            System.out.println(xmlResult);

        System.out.println("Validating XML against Schema");

            SchemaValidator schemaValidator =  new SchemaValidator();

            schemaValidator.validateXMLToSchema(xmlResult);

    }


}
