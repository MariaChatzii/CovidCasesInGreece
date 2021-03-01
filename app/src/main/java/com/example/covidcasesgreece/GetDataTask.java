package com.example.covidcasesgreece;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class GetDataTask extends AsyncTask<String, Void, List<AreaRecord>> {

    public static final String TAG = "RestApp";

    private final RecordsArrayAdapter adapter;

    public GetDataTask(RecordsArrayAdapter adapter){
      this.adapter = adapter;
    }

    public String downloadRestData(String remoteUrl){
        Log.d(TAG, "Downloading data.....");
        StringBuilder sb = new StringBuilder();

        try{
            URL url = new URL(remoteUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty ("Authorization", "Token " +BuildConfig.CovidApiKey);

            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                Log.d(TAG, "Request Accepted");

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line = reader.readLine();
                while (line != null){
                    sb.append(line).append("\n");

                    line = reader.readLine();
                }
                reader.close();

                return sb.toString();
            }
            else {
                Log.d(TAG, "Something went wrong. Response code was "+ responseCode);
            }
        }catch (Exception e){
            Log.e(TAG, "Error happened!", e);
            return "";
        }
        return "";
    }

    @Override
    protected List<AreaRecord> doInBackground(String... strings) {
        String url = strings[0];
        Log.d(TAG, "Doing task in background for url "+url);

        String recordsJson = downloadRestData(url);

        JsonParser jsonParser = new JsonParser();
        return jsonParser.parsePostData(recordsJson);
    }

    @Override
    protected void onPostExecute(List<AreaRecord> records) {
        Log.d(TAG, "Just got results!");
        adapter.setRecordsList(records);
    }
}