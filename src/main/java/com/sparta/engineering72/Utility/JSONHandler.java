package com.sparta.engineering72.Utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONHandler {

    public static JSONArray jsonArray = new JSONArray();

    public static JSONObject populateJSONObject(ReportPacker reportPacker){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalRabbits", reportPacker.getTotalRabbits());
        jsonObject.put("maleRabbits", reportPacker.getMaleFoxes());
        jsonObject.put("femaleRabbits", reportPacker.getFemaleRabbits());
        jsonObject.put("totalFoxes", reportPacker.getTotalFoxes());
        jsonObject.put("maleFoxes", reportPacker.getMaleFoxes());
        jsonObject.put("femaleFoxes", reportPacker.getFemaleFoxes());
        jsonObject.put("rabbitAgeDeaths", reportPacker.getRabbitAgeDeaths());
        jsonObject.put("rabbitPreyDeaths", reportPacker.getRabbitPreyDeaths());
        jsonObject.put("foxDeaths", reportPacker.getFoxDeaths());
        return jsonObject;
    }

    public static JSONArray populateJSONArray(JSONObject jsonObject){
        jsonArray.add(jsonObject);
        return jsonArray;
    }

}
