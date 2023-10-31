package com.example.myjavafxapp;

import com.tools.tool.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {


    @FXML
    private Label message;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         message.setText(MainController.userParams);
    }

    public void LoadConsultation(ActionEvent event){

        try{


            Parent root = FXMLLoader.load(getClass().getResource("consultation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Consultation");
            stage.show();


        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void LoadMedecin(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("medecin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Medecin");
            stage.show();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
