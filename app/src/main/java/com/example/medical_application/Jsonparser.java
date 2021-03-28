package com.example.medical_application;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Jsonparser {
    private HashMap<String,String> ParseJsonObject (JSONObject object) {
        HashMap<String,String> DataList=new HashMap<>();
        try {
            String name=object.getString("name");
            String latitude=object.getJSONObject("geometry").getJSONObject("location").getString("lat");
            String longitude=object.getJSONObject("geometry").getJSONObject("location").getString("lng");
            DataList.put("name",name);
            DataList.put("lat",latitude);
            DataList.put("lng",longitude);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return DataList;
    }
    private List<HashMap<String,String>> parseJsonArray(JSONArray jsonArray){
        List<HashMap<String,String>> dataList=new ArrayList<>();
        for (int i=0; i>jsonArray.length();i++){
            try {
                HashMap<String,String> data=ParseJsonObject((JSONObject)jsonArray.get(i));
                dataList.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }
    public List<HashMap<String,String>> parseResult (JSONObject object){
        JSONArray jsonArray=null;
        try {
            jsonArray=object.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parseJsonArray(jsonArray);
    }

}

