package edu.metu.cng457.assignment4.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the concert service.
 */
public class ConcertService {
    /**
     * Adds a concert.
     *
     * @param festivalId    The festival id.
     * @param festivalRunId The festival run id.
     * @param performers    The name of performers.
     */
    public void addConcert(String festivalId, String festivalRunId, List<String> performers) {
        try {
            String response = "";
            HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/addfestivalrun").openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            JSONObject festivalObject = new JSONObject();
            festivalObject.put("id", Integer.parseInt(festivalId));

            JSONObject festivalRunObject = new JSONObject();
            festivalRunObject.put("belongsToFestival", festivalObject);
            festivalRunObject.put("id", Integer.parseInt(festivalRunId));

            JSONObject concertObject = new JSONObject();
            concertObject.put("belongsFestivalRun", festivalRunObject);

            connection.getOutputStream().write(concertObject.toJSONString().getBytes());
            if (connection.getResponseCode() == 200) {
                System.out.println("Succesfully added");
            } else {
                System.out.println("Failed to add");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the longest concerts.
     *
     * @return list of concerts.
     */
    public List<String> getLongestConcerts() {
        try {
            String response = "";
            HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/longestconcerts/").openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 200) {
                Scanner scanner = new Scanner(connection.getInputStream());
                while (scanner.hasNextLine()) {
                    response += scanner.nextLine();
                }
                scanner.close();
            }

            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(response);
            List<String> result = new ArrayList<>();
            for (Object o : array) {
                JSONObject object = (JSONObject) o;
                result.add(object.get("name").toString());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
