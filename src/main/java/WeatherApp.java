import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
//import org.json.JSONObject;
//import java.util.Scanner;

public class WeatherApp {
    // Copy your API-KEY here
    public final static String apiKey = "7a5983e010144e83b66135412232302";


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String weather = null;
        String city = "CITY";
        while (weather == null) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Select One City Name");
            city = input.next();
            weather = getWeatherData(city);
            if (weather == null) {
                System.out.println("This City Is Not Valid");
            }
        }
        int humidity = getHumidity(weather);
        System.out.println("Humidity Of " + city + " : " + humidity);
        double temperature = getTemperature(weather);
        System.out.println("Temperature Of " + city + " : " + temperature);
        double wind_speed = getwindSpeed(weather);
        System.out.println("Wind Speed OF " + city + " : " + wind_speed);
        String wind_direction = getWindDirection(weather);
        System.out.println("Wind Direction OF " + city + " : " + wind_direction);
        input.close();
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
        } catch (Exception e) {
            return null;
        }
    }

    public static double getTemperature(String weatherJson) {
        try {
            JSONObject temperature = new JSONObject(weatherJson);
            JSONObject current_temperature = temperature.getJSONObject("current");
            double degree = current_temperature.getDouble("temp_c");
            return degree;
        } catch (Exception e) {
            e.printStackTrace();
            return Double.NaN;
        }
    }

    public static int getHumidity(String weatherJson) {
        try {
            JSONObject humidity = new JSONObject(weatherJson);
            JSONObject current_humidity = humidity.getJSONObject("current");
            int hum = current_humidity.getInt("humidity");
            return hum;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static double getwindSpeed(String weatherJson){
        try{
            JSONObject wind_speed = new JSONObject(weatherJson);
            JSONObject current_wind_speed = wind_speed.getJSONObject("current");
            double speed = current_wind_speed.getDouble("wind_kph");
            return speed;
        }
        catch (Exception e){
            e.printStackTrace();
            return Double.NaN;
        }
    }

    public static String getWindDirection(String weatherJson){
        try {
            JSONObject wind_direction = new JSONObject(weatherJson);
            JSONObject current_wind_direction = wind_direction.getJSONObject("current");
            String direction = current_wind_direction.getString("wind_dir");
            return direction;
        }
        catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

}
