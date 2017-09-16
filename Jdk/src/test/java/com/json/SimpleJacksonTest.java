package com.json;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jdk.bean.Production;
import org.junit.Test;

import java.io.StringWriter;

public class SimpleJacksonTest {
    @Test
    public void testObjSerialiable() throws Exception {
        Production production = new Production(1,"PC",4999d,12,"Lenovo");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.writeValue(System.out,production);
    }
}
