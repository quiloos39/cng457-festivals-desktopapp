package edu.metu.cng457.assignment4.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Responsible for controlling the main window.
 */
public class MainController {

    /**
     * Checkbox for festival
     */
    @FXML
    private CheckBox selectAddFestival;

    /**
     * Checkbox for concert
     */
    @FXML
    private CheckBox selectAddConcert;

    /**
     * Checkbox for statistic
     */
    @FXML
    private CheckBox selectAddStatistics;

    /**
     * Triggers when the user clicks the continue button.
     *
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void onContinue(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;

        if (selectAddFestival.isSelected()) {
            stage = (Stage) selectAddFestival.getScene().getWindow();
            URL fxmlLocation = getClass().getResource("/edu/metu/cng457/assignment4/AddFestivalRun.fxml");
            root = FXMLLoader.load(fxmlLocation);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (selectAddConcert.isSelected()) {
            stage = (Stage) selectAddFestival.getScene().getWindow();
            URL fxmlLocation = getClass().getResource("/edu/metu/cng457/assignment4/AddConcert.fxml");
            root = FXMLLoader.load(fxmlLocation);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (selectAddStatistics.isSelected()) {
            stage = (Stage) selectAddFestival.getScene().getWindow();
            URL fxmlLocation = getClass().getResource("/edu/metu/cng457/assignment4/Statistics.fxml");
            root = FXMLLoader.load(fxmlLocation);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}