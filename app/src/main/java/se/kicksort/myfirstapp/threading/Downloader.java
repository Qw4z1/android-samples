package se.kicksort.myfirstapp.threading;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {

    public static String downloadData(String stringUrl) {
        String response = "";
        HttpURLConnection connection = null;
        try {
            URL url = new URL(stringUrl);
            connection = (HttpURLConnection) url.openConnection();

            InputStream content = connection.getInputStream();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
            String s = "";
            while ((s = buffer.readLine()) != null) {
                response += s;
            }

        } catch (Exception e) {
            e.printStackTrace();
            response = e.getMessage();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return response;
    }
}
