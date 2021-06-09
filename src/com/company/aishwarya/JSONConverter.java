package com.company.aishwarya;

import org.json.*;

public class JSONConverter {


    public JSONObject convertXMLToJSON(String xmlString) {
        JSONObject json = null;
        try {
            json = XML.toJSONObject(xmlString);
            String jsonPrettyPrintString = json.toString(4); // json pretty print
            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }

        return json;
    }
}
