package edu.metu.cng457.assignment4.service;

import edu.metu.cng457.assignment4.utils.Connection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles festival related operations.
 */
public class FestivalService {
    /**
     * Returns a list of festivals.
     *
     * @return List of festivals.
     */
    public List<String> getFestivals() {
        List<String> festivals = new ArrayList<>();
        try {
            String response = Connection.get("http://localhost:8080/getallfestivals");
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(response);
            for (Object o : array) {
                JSONObject object = (JSONObject) o;
                festivals.add(object.get("id").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return festivals;
    }

    /**
     * Returns a list of festival runs.
     *
     * @param id id of festival
     * @return list of festival runs.
     */
    public List<String> getFestivalRuns(String id) {
        List<String> festivalRuns = new ArrayList<>();
        try {
            String response = Connection.get("http://localhost:8080/getallfestivalruns/".concat(id));
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(response);
            for (Object o : array) {
                JSONObject object = (JSONObject) o;
                festivalRuns.add(object.get("id").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return festivalRuns;
    }

    /**
     * Adds a new festival.
     *
     * @param festivalId id of festival
     * @param date       date of festival
     * @param duration   duration of festival
     */
    public void addFestival(String festivalId, LocalDate date, String duration) {
        try {
            String response = "";
            HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/addfestivalrun").openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            JSONObject festivalObject = new JSONObject();
            festivalObject.put("id", Integer.parseInt(festivalId));

            JSONObject felstivalRunObject = new JSONObject();
            felstivalRunObject.put("belongsToFestival", festivalObject);
            felstivalRunObject.put("date", date.toString());
            felstivalRunObject.put("duration", duration);

            connection.getOutputStream().write(felstivalRunObject.toJSONString().getBytes());
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
     * Returns a list of popular festivals.
     *
     * @return list of popular festivals.
     */
    public List<String> getPopularFestivals() {
        List<String> popularFestivals = new ArrayList<>();
        try {
            String response = Connection.get("http://localhost:8080/popularfestivals");
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(response);
            for (Object o : array) {
                JSONObject object = (JSONObject) o;
                popularFestivals.add(object.get("name").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return popularFestivals;
    }
}
