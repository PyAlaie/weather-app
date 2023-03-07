package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Scanner;
public class WeatherApp {
    public final static String apiKey = "b963b118851e4720a4164608232302";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter The Name Of Your City: ");
        String cityName = input.nextLine().trim();

        if(isValidCity(cityName)){
            if(cityName.toLowerCase().equals("ardabil")){
                System.out.println("YASHASIN :)");
            }
            String rawData = getWeatherData(cityName);

            System.out.println(" ===== WEATHER REPORT FOR " + getCountry(rawData) + "-" + cityName.substring(0, 1).toUpperCase() + cityName.substring(1) + " ===== \n");

            double temperature = getTemperature(rawData);
            int humidity = getHumidity(rawData);
            double windSpeed = getWindSpeed(rawData);
            double windAngle = getWindAngle(rawData);

            System.out.print("Temperature: " + temperature + "\t\t");
            System.out.println("Humidity: " + humidity);

            System.out.print("Wind Speed: " + windSpeed + "\t\t");
            System.out.println("Wind Angle: " + windAngle);
        }
        else {
            System.out.println("Something Went Wrong :(");
        }

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

    public static double getWindSpeed(String weatherJson){
        double temp = new JSONObject(weatherJson).getJSONObject("current").getInt("wind_kph");
        return temp;
    }

    public static double getWindAngle(String weatherJson){
        double temp = new JSONObject(weatherJson).getJSONObject("current").getInt("wind_degree");
        return temp;
    }

    // TODO: Write getHumidity function returns humidity percentage of city by given json string
    public static int getHumidity(String weatherJson){
        int res = new JSONObject(weatherJson).getJSONObject("current").getInt("humidity");
        return res;
    }

    public static String getCountry(String weatherJson){
        String res = new JSONObject(weatherJson).getJSONObject("location").getString("country");
        return res;
    }

    public static boolean isValidCity(String cityName) {
        try{
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + cityName);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}