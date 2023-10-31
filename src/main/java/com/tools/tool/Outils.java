package com.tools.tool;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Outils {
    public static void showConfirmationMessage(String titre, String message){
        Alert a = new Alert (Alert.AlertType.CONFIRMATION);
        a.setTitle(titre);
        a.setContentText(message);

        a.showAndWait();
        }

        public static void ShowErrorMessage(String titre, String message){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle(titre);
            a.setContentText(message);
            a.showAndWait();
        }

        private void loadPage(ActionEvent event, String title, String url) throws IOException{
          ((Node) event.getSource()).getScene().getWindow().hide();

            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        }

        public static  void load(ActionEvent event,String title, String url) throws IOException
        {
           new Outils().loadPage(event, title, url);
        }


    private void loadSubPage(ActionEvent event, String title, String url) throws IOException{
       // ((Node) event.getSource()).getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public static  void loadSub(ActionEvent event,String title, String url) throws IOException
    {
        new Outils().loadSubPage(event, title, url);
    }
}
