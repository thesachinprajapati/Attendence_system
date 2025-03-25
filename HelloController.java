package com.example.attendence_system;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;

public class HelloController {

    @FXML
    private ComboBox<String> roleSelector;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        // Setting items for ComboBox in Java (fixing FXML issue)
        roleSelector.setItems(FXCollections.observableArrayList("Faculty", "Admin"));
    }

    @FXML
    protected void onLoginClick() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String role = roleSelector.getValue();

        if (username.isEmpty() || password.isEmpty() || role == null) {
            statusLabel.setText("Please fill all fields!");
            return;
        }

        if (authenticate(username, password, role)) {
            statusLabel.setText("Login successful as " + role + "!");
        } else {
            statusLabel.setText("Invalid credentials!");
        }
    }

    private boolean authenticate(String username, String password, String role) {
        return (role.equals("Faculty") && username.equals("faculty") && password.equals("faculty123"))
                || (role.equals("Admin") && username.equals("admin") && password.equals("admin123"));
    }
}
