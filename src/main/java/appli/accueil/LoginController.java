package appli.accueil;
import repository.UtilisateurRepository;
import model.Utilisateur;
import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;


public class LoginController {
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();


    @FXML
    private Button bountonInscription;

    @FXML
    private Button boutonMdpOubliée;

    @FXML
    private Button boutonconnexion;

    @FXML
    private TextField email;

    @FXML
    private Label labelErreur;

    @FXML
    private PasswordField mdp;

    @FXML
    private Label welcomeText;
    UtilisateurRepository repository = new UtilisateurRepository();
    @FXML

    void Login(ActionEvent event) throws SQLException {
        String emailInput = email.getText();
        String password = mdp.getText();
       if (emailInput.isEmpty() || password.isEmpty()) {
           System.out.println("Veullez entrer votre identifiants");
           labelErreur.setText("Veuillez entrer votre identifiants");
           labelErreur.setStyle("-fx-text-fill: red;");
           return;
       }

Utilisateur utilisateur=repository.getUtilisateurParEmail(email.getText());
Utilisateur utilisateur1= repository.getUtilisateurParEmail(mdp.getText());

if (utilisateur.getMdp() .equals( mdp.getText())){
    System.out.println("Veuillez entrer votre identifiants");

        }

        System.out.println("Email: " + emailInput);
        System.out.println("Mot de passe: " + password);

        if (emailInput.equals("r@r.r") && password.equals("Test1234")) {
            System.out.println("Connexion réussie !");
            labelErreur.setText("Connexion réussie !");
            labelErreur.setStyle("-fx-text-fill: blue;");
        } else {
            System.out.println("Identifiants incorrects.");
            labelErreur.setText("Identifiants incorrects.");
            labelErreur.setStyle("-fx-text-fill: black;");
        }
    }
    @FXML
    void btnMdpOublie(ActionEvent event) {

    }

    @FXML
    void retourInscription(ActionEvent event) {
        try {
            StartApplication.changeScene("Inscription");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

