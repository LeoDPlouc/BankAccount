package com.dp.bankaccount;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.net.ssl.HttpsURLConnection;

public class API {

    public static Account[] FetchAcounts(){
        String json = FetchJson();

        Gson gson = new Gson();
        return gson.fromJson(json, Account[].class);
    }

    private static String FetchJson()
    {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> futureJson = executorService.submit(() -> FetchTask());

        String json = null;
        try {
            json = futureJson.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    private static String FetchTask() {
        String res = "";
        try {
            URL url = new URL(Encrypted.getUrl());
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            BufferedReader is = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = is.readLine()) != null) {
                res += line + "\n";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
