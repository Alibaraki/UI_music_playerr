package com.example.newestdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    //@FXML
    //private Label welcomeText;

    //@FXML
    //protected void onHelloButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField EnterUserNameTextField;
    @FXML
    private PasswordField EnterPasswordTextField;

    public void loginButtonOnAction(ActionEvent e){
        if(EnterUserNameTextField.getText().isBlank() == false && EnterPasswordTextField.getText().isBlank() == false){
            //loginMessageLabel.setText("wrong username or password");

            validateLogin();
        } else {
            loginMessageLabel.setText("please enter username and password");

        }
    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void validateLogin(){
        DBconnection connectNow = new DBconnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE username = '" + EnterUserNameTextField.getText() + "' and password = '" + EnterPasswordTextField.getText() + "'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    loginMessageLabel.setText("Welcome!");
                } else{
                    loginMessageLabel.setText("Invalid Login. Please try again.");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}