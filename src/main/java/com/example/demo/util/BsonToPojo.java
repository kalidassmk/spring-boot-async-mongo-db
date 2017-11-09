package com.example.demo.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;

import java.io.IOException;

/**
 * Created by Kalidass Mahalingam on 11/8/2017.
 */
public class BsonToPojo {

    /**
     * Instantiates a new Bson to pojo.
     */
    public BsonToPojo() {
    }

    /**
     * Pojo to bson document.
     *
     * @param pojo the pojo
     *
     * @return the document
     */
    public static Document pojoToBson(Object pojo) {
        Document doc = Document.parse(Json.toJson(pojo).toString());
        return doc;
    }

    /**
     * Bson to pojo t.
     *
     * @param <T> the type parameter
     * @param doc the doc
     * @param c   the c
     *
     * @return the t
     */
    public static <T> T BsonToPojo(Document doc, Class<T> c) {
        try {
            JsonNode jsonNode = Json.toJson(doc);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(doc.toString());
            return mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(jsonNode.toString(), c);
        } catch (JsonParseException var4) {
            var4.printStackTrace();
        } catch (JsonMappingException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return null;
    }
}
