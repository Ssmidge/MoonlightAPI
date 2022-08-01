package xyz.ssmidge.moonlight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.Locale;

public class MoonlightAPI {

    private static final String API_URL = "http://127.0.0.1:8080/api";
    private static final String USER_AGENT = "Mozilla/5.0";

    /**
     *
     * @param license The license key for the product that is using Moonlight.
     * @param discordid The Discord ID of the user.
     * @return If the key is valid
     */
    public static boolean isValid(String license, String discordid) {
        String format = String.format("discordid=%s&license=%s", discordid, license);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(API_URL + "/user/check").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);

            // Data
            httpURLConnection.setDoOutput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(format.getBytes());
            os.flush();
            os.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            if(httpURLConnection.getResponseCode() == 200 && response.toString().toLowerCase(Locale.ROOT).contains('"' + "error" + '"' + ":false")) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("fasfa", "3779185a56911960069"));
    }
}