package com.zenlabs.zenstories;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonConvertor {
    String fileName;
    Context context;

    public JsonConvertor(String fileName, Context context) {
        this.fileName = fileName;
        this.context = context;
    }

    public JSONObject getJsonObject() {

        //Create input stream
        try {
            InputStream inputStream = context.getResources().getAssets().open(fileName);
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());

            //returns the json object
            return jsonObject;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

