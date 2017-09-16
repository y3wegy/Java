package com.json;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jdk.bean.Production;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

public class SimpleJacksonTest {
    public static final Logger logger = Logger.getLogger(SimpleJacksonTest.class);

    /**
     * Obj->Json
     * @throws Exception
     */
    @Test
    public void testObjSerialiable() throws Exception {
        Production production = new Production(1,"PC",4999d,12,"Lenovo");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.writeValue(System.out,production);
    }

    /**
     * create Json field one by one
     */
    @Test
    public void testGenerateJson() throws IOException {
        JsonFactory factory = new JsonFactory();
        StringWriter stringWriter = new StringWriter();
        JsonGenerator generator = factory.createGenerator(stringWriter);

        // start writing with {
        generator.writeStartObject();
        generator.writeFieldName("title");
        generator.writeString("Free Music Archive - Albums");
        generator.writeFieldName("dataset");
        // start an array
        generator.writeStartArray();
        generator.writeStartObject();
        generator.writeStringField("album_title", "A.B.A.Y.A.M");
        generator.writeEndObject();
        generator.writeEndArray();
        generator.writeEndObject();

        generator.close();

        logger.info(stringWriter.toString());
    }
}
