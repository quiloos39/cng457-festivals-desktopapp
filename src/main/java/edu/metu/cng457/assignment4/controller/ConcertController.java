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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Responsible for controlling the concert scene.
 */
public class ConcertController {
    /**
     * The combobox for selecting the festival.
     */
    @FXML
    ComboBox festivals;
    /**
     * The combobox for selecting the concert.
     */
    @FXML
    ComboBox festivalRuns;
    /**
     * The text field for the performer's names.
     */
    @FXML
    TextField performersNames;
    /**
     * The festival service.
     */
    private final FestivalService festivalService = new FestivalService();
    /**
     * The concert service.
     */
    private final ConcertService concertService = new ConcertService();

    /**
     * Triggered at initial rendering
     */
    @FXML
    public void initialize() {
        festivals.setItems(FXCollections.observableArrayList(festivalService.getFestivals()));
    }

    /**
     * Triggers when festival combobox changed
     *
     * @param event
     */
    @FXML
    private void onFestivalChange(ActionEvent event) {
        String value = (String) ((ComboBox) event.getSource()).getValue();
        festivalRuns.setItems(FXCollections.observableArrayList(festivalService.getFestivalRuns(value)));
    }

    /**
     * Triggers when add button is clicked
     *
     * @param event
     */
    @FXML
    private void onAdd(ActionEvent event) {
        String festival = (String) festivals.getValue();
        String festivalRun = (String) festivalRuns.getValue();
        String performers = performersNames.getText();
        concertService.addConcert(festival, festivalRun, List.of(performers.split(",")));
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
