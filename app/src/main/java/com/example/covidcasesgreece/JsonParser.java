package com.example.covidcasesgreece;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static final String TAG = "JsonParser";

    private static final String AREA_NAME = "area";
    private static final String DAY_DIFF = "daydiff";
    private static final String DAY_TOTAL = "daytotal";
    private static final String TOTAL_VACCINATIONS = "totalvaccinations";


    public List<AreaRecord> parsePostData(String postJsonData){
        List<AreaRecord> recordsList = new ArrayList<>();

        try{
            JSONArray jsonPostArray = new JSONArray(postJsonData);

            for(int i=0; i< jsonPostArray.length(); i++) {
                JSONObject postJsonObject = jsonPostArray.getJSONObject(i);
                String name = postJsonObject.getString(AREA_NAME);
                int dayDiff = postJsonObject.getInt(DAY_DIFF);
                int dayTotal = postJsonObject.getInt(DAY_TOTAL);
                int totalVaccinations = postJsonObject.getInt(TOTAL_VACCINATIONS);

                AreaRecord record = new AreaRecord();
                record.setName(name);
                record.setDayDiff(dayDiff);
                record.setDayTotal(dayTotal);
                record.setTotalVaccinations(totalVaccinations);

                recordsList.add(record);
            }

        }catch (JSONException ex){
            Log.e(TAG, "Error in json parsing", ex);
            return recordsList;
        }
        return recordsList;
    }
}