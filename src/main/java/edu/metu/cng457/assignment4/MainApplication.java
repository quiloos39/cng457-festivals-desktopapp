package edu.metu.cng457.assignment4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class.
 */
public class MainApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    /**
     * Starts the application.
     *
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 679, 210);
        stage.setTitle("Festival Manager");
        stage.setScene(scene);
        stage.show();
    }
}