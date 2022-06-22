package edu.metu.cng457.assignment4.controller;

import edu.metu.cng457.assignment4.service.FestivalService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Responsible for handling the FestivalController.fxml
 */
public class FestivalController {

    /**
     * The service for the festival.
     */
    private final FestivalService festivalService = new FestivalService();

    /**
     * Combox for selecting the festival.
     */
    @FXML
    private ComboBox festivals;

    /**
     * Text field for duration
     */
    @FXML
    private TextField duration;

    /**
     * Data picker
     */
    @FXML
    private DatePicker date;

    @FXML
    private void initialize() {
        festivals.setItems(FXCollections.observableArrayList(festivalService.getFestivals()));
    }

    /**
     * Triggers when add button clicked
     *
     * @param event
     */
    @FXML
    private void onAdd(ActionEvent event) {
        LocalDate dateTime = date.getValue();
        String duration = this.duration.getText();
        String festival = (String) festivals.getValue();
        festivalService.addFestival(festival, dateTime, duration);
    }

    /**
     * Triggers when edit button clicked
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
