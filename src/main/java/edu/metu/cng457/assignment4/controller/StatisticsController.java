package edu.metu.cng457.assignment4.controller;

import edu.metu.cng457.assignment4.service.ConcertService;
import edu.metu.cng457.assignment4.service.FestivalService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Responsible for the statistics view.
 */
public class StatisticsController {

    /**
     * ListView for festivals
     */
    @FXML
    ListView popularFestivals;
    /**
     * ListView for concerts
     */
    @FXML
    ListView longestConcerts;
    /**
     * Checkbox for popular festivals
     */
    @FXML
    CheckBox checkPopularFestival;
    /**
     * Checkbox for longest concerts
     */
    @FXML
    CheckBox checkLongestConcert;
    /**
     * Festival service.
     */
    private final FestivalService festivalService = new FestivalService();
    /**
     * Concert service.
     */
    private final ConcertService concertService = new ConcertService();

    /**
     * Triggers when show button is clicked
     *
     * @param event
     */
    @FXML
    private void onShow(ActionEvent event) {
        if (checkPopularFestival.isSelected()) {
            popularFestivals.setItems(FXCollections.observableArrayList(festivalService.getPopularFestivals()));
        }
        if (checkLongestConcert.isSelected()) {
            longestConcerts.setItems(FXCollections.observableArrayList(concertService.getLongestConcerts()));
        }
    }

    /**
     * Triggers when back button is clicked
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void onBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/edu/metu/cng457/assignment4/Main.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
