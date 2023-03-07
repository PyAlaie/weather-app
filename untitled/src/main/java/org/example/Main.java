package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;
public class Main {
    public final static String apiKey = "b963b118851e4720a4164608232302";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter The Name Of Your City: ");
        String cityName = input.nextLine().trim();

        String rawData = getWeatherData(cityName);

        double temperature = getTemperature(rawData);
        int humidity = getHumidity(rawData);

        System.out.println("temperature: " + temperature);
        System.out.println("humidity: " + humidity);
    }


    /**
     * Retrieves weather data for the specified city.
     *
     * @param city the name of the city for which weather data should be retrieved
     * @return a string representation of the weather data, or null if an error occurred
     */
    public static String getWeatherData(String city) {
        try {
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            return stringBuilder.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // TODO: Write getTemperature function returns celsius temperature of city by given json string
    public static double getTemperature(String weatherJson){
        double temp = new JSONObject(weatherJson).getJSONObject("current").getInt("temp_c");
        return temp;
    }

    // TODO: Write getHumidity function returns humidity percentage of city by given json string
    public static int getHumidity(String weatherJson){
        int res = new JSONObject(weatherJson).getJSONObject("current").getInt("humidity");
        return res;
    }
}