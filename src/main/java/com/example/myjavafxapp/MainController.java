package com.example.myjavafxapp;



import com.isi.dao.IUser;
import com.isi.dao.UserImpl;
import com.isi.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class MainController {

    @FXML
    private TextField emailtxt;
    @FXML
    private PasswordField passwordtxt;
    private IUser userdao = new UserImpl();
    public static String userParams;

  public void getLogin(ActionEvent event)
  {
      String email = emailtxt.getText();
      String password = passwordtxt.getText();



      if(email.equals("") || password.equals(""))
      {
       //Notification.NotifError("Erreur","Veuillez remplir tous les champs");
       Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Erreur");
          alert.setContentText("Erreur Veuillez remplir tous les champs");
          alert.showAndWait();

      }else{
            User user = userdao.getConnection(email,password);
            if (user != null){

                if (user.getMedecin()!= null){
                    userParams = "Bienvenu" + " " + user.getMedecin().getPrenom() + " " + user.getMedecin().getNom();
                }

                if (user.getSecretaire()!= null){
                    userParams = "Bienvenu" + " " + user.getSecretaire().getPrenom() + " " + user.getSecretaire().getNom();
                }



                    try{
                        ((Node) event.getSource()).getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("title");
                        stage.show();

                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText("Email ou mot de passe Incorrect !");
                alert.showAndWait();

            }
      }

  }
}