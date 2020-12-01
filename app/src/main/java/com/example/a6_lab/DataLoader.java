package com.example.a6_lab;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public abstract class DataLoader extends AsyncTask<Void, Void, String[]> {

    protected String[] doInBackground(Void... params) {
        try {
            return DataManager.getRateFromECB();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return new String[]{sw.toString()};
        }
    }



   // public abstract void onPostExecute(String[] result);
}
