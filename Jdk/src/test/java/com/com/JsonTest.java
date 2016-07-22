package com.com;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by a549238 on 7/18/2016.
 */
public class JsonTest {
    @Test
    public void testJsonObject()
    {
        JSONObject json = new JSONObject();
        try {
            json.put("name","1");
            json.put("value","2");
            System.out.println(json.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsonArray()
    {

        JSONObject json = new JSONObject();
        try {
            json.put("name","1");
            json.put("value","2");
            System.out.println(json.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(json);
        System.out.println(jsonArray.toString());
    }
}
