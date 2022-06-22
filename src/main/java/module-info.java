module edu.metu.cng457.assignment4.cng457assignment4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens edu.metu.cng457.assignment4 to javafx.fxml;
    exports edu.metu.cng457.assignment4;
    exports edu.metu.cng457.assignment4.controller;
    opens edu.metu.cng457.assignment4.controller to javafx.fxml;
}