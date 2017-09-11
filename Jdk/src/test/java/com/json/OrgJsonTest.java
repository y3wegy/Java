package com.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

/**
 * Created by a549238 on 7/18/2016.
 */
public class OrgJsonTest {
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

    @Test
    public void testParse(){
        String notJson ="$FUND_LIST Domestic Dividends Receivable as at $dd$UMMM$yyyy";
        String obJson = "{\"INDIVIDUAL_FUND_REPORT\":\"rts_domestic_dividends_receivable_xls\",\"GROUP_FUND_REPORT\":\"rts_domestic_dividends_receivable_xls\"}";
        String arrjson ="[\"1\",\"2\"]";
        JSONTokener jsonTocker = new JSONTokener(notJson);
        Object obj = null;
        try {
            obj = jsonTocker.nextValue();
            System.out.println(obj instanceof String);

            jsonTocker = new JSONTokener(obJson);
            obj = jsonTocker.nextValue();
            System.out.println(obj instanceof JSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
