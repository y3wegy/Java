package com.json;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jdk.bean.Production;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleJacksonTest {
    public static final Logger logger = Logger.getLogger(SimpleJacksonTest.class);
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS XX");

    private static ObjectMapper objectMapper = null;
    @BeforeClass
    public static void setUp(){
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true); // format
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true); //allow '
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,true);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.setDateFormat(simpleDateFormat);
    }

    /**
     * use ObjectMapper to serialiable Obj
     * @throws Exception
     */
    @Test
    public void testObjSerialiable() throws Exception {
        Production production = new Production(1,"PC",4999d,12,"Lenovo",null, Calendar.getInstance().getTime());
        objectMapper.writeValue(System.out,production);
        logger.info("\n---------");
        logger.info(objectMapper.writeValueAsString(production));
    }

    /**
     * create Json field one by one ,then deserialiable Json
     */
    @Test
    public void testGenerateJson() throws IOException {
        StringWriter stringWriter = new StringWriter();
        JsonGenerator generator = objectMapper.getFactory().createGenerator(stringWriter);

        // start writing with {
        generator.writeStartObject();
        generator.writeStringField("id","1");
        generator.writeStringField("subject","PC");
        generator.writeNumberField("price",4999d);
        generator.writeNumberField("count",12);
        generator.writeStringField("description","Lenevo");

        // start an array
        generator.writeArrayFieldStart("component");
        generator.writeStartObject();
        generator.writeNumberField("id", 2);
        generator.writeStringField("subject", "CPU");
        generator.writeEndObject();
        generator.writeStartObject();
        generator.writeNumberField("id", 3);
        generator.writeStringField("subject", "Memory");
        generator.writeEndObject();
        generator.writeStartObject();
        generator.writeNumberField("id", 4);
        generator.writeStringField("subject", "Disk");
        generator.writeEndObject();
        generator.writeEndArray();
        generator.writeEndObject();

        generator.close();

        logger.info(String.format("JSON String:%s",stringWriter.toString()));

        //convert json to bean;
        Production product = objectMapper.readValue(stringWriter.toString(),Production.class);
        logger.info(String.format("parse json to String:%s",product));
    }

    @Test
    public void testParseJsonTree() throws IOException {
        Production cpu = new Production(2,"CPU",999d,13,"Intel",null,Calendar.getInstance().getTime());
        Production production = new Production(1,"PC",4999d,12,"Lenovo",new Production[]{cpu}, Calendar.getInstance().getTime());
        String jsonStr = objectMapper.writeValueAsString(production);
        JsonNode jsonNode = objectMapper.readTree(jsonStr);
        JsonNode components = jsonNode.get("component");
        for (JsonNode node :
                components) {
            logger.info(String.format("component name:%s",node.get("subject")));

        }
    }
}
