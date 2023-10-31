package com.example.myjavafxapp;

import com.isi.dao.IMedecin;
import com.isi.dao.MedecinImpl;
import com.isi.entities.Medecin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MedecinController implements Initializable {

    @FXML
    private TextField nomTxt;
    @FXML
    private TextField prenomtxt;
    @FXML
    private TextField telephonetxt;

    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupp;
    @FXML
    private Button btnValider;
    @FXML
    private Button btnAnnuler;
    @FXML
    private TableView<Medecin> medecintable;
    @FXML
    private TableColumn<Medecin, Integer> idcolumn;
    @FXML
    private TableColumn<Medecin, String> nomcolumn;
    @FXML
    private TableColumn<Medecin, String> prenomcolumn;
    @FXML
    private TableColumn<Medecin, String> telcolumn;
    private IMedecin medecindao = new MedecinImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
          idcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
          nomcolumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
          prenomcolumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
          telcolumn.setCellValueFactory(new PropertyValueFactory<>("tel"));
          load();
    }

    public void insert (ActionEvent event){
        Medecin medecin = new Medecin();
        medecin.setNom(nomTxt.getText());
        medecin.setPrenom(prenomtxt.getText());
        medecin.setTel(telephonetxt.getText());

        int ok = medecindao.add(medecin);
        if(ok != 0){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setContentText("Données ajoutées");
            alert.showAndWait();
            load();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Erreur");
            alert.showAndWait();
        }
    }
    public void reset (ActionEvent event){

    }

    public void delete (ActionEvent event){

    }

    public void update (ActionEvent event){

    }

    public void load(){
        ObservableList<Medecin> medecins = FXCollections.observableArrayList();
        List<Medecin> medecinList = medecindao.getAll();
        for (Medecin m : medecinList){
            medecins.add(m);
        }

        medecintable.setItems(medecins);
    }




    //--------------------------------------------------

    @FXML
    private TextField nomtxt;
    @FXML
    private TextField prenomtxt;
    @FXML
    private TextField teltxt;

    @FXML
    private Button validerbt;
    @FXML
    private Button annulerbt;
    @FXML
    private Button modifierbt;
    @FXML
    private Button supprimerbt;

    @FXML
    private TableView<Medecin> medecintable;
    @FXML
    private TableColumn<Medecin, Integer> idColumn;
    @FXML
    private TableColumn<Medecin, String> nomColumn;
    @FXML
    private TableColumn<Medecin, String> prenomColumn;
    @FXML
    private TableColumn<Medecin, String> telColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        telColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));

        load();

        modifierbt.setDisable(true);
        supprimerbt.setDisable(true);
    }

    public void insert(ActionEvent event) {

        medecin = new Medecin();
        medecin.setNom(nomtxt.getText());
        medecin.setPrenom(prenomtxt.getText());
        medecin.setTel(teltxt.getText());

        int ok = medecindao.add(medecin);
        if(ok != 0) {
            Notification.NotifSucces("Success", "Données ajoutées");
            load();
            resete(event);
        } else {
            Notification.NotifError("Error", "Erreur");
        }
    }
    public void resete(ActionEvent event) {

        validerbt.setDisable(false);
        modifierbt.setDisable(true);
        supprimerbt.setDisable(true);
        nomtxt.setText("");
        prenomtxt.setText("");
        teltxt.setText("");
    }

    public void load() {

        ObservableList<Medecin> medecins = FXCollections.observableArrayList();

        List<Medecin> medecinList = medecindao.getAll();
        for (Medecin m : medecinList) {
            medecins.add(m);
        }
        medecintable.setItems(medecins);
    }

    public void tableClick(MouseEvent event) {
        medecin = medecintable.getSelectionModel().getSelectedItem();
        nomtxt.setText(medecin.getNom());
        prenomtxt.setText(medecin.getPrenom());
        teltxt.setText(medecin.getTel());

        validerbt.setDisable(true);

        modifierbt.setDisable(false);
        supprimerbt.setDisable(false);
    }

}

