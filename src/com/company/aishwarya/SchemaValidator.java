package com.company.aishwarya;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class SchemaValidator {

    public void validateXMLToSchema(String xml){
        File schemaFile = new File("src/com/company/data/schema.xsd");

        Source xmlFile = new StreamSource(xml);
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);

            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(validator);
            System.out.println(xmlFile.getSystemId());
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
        } catch (IOException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
        }
    }
}
