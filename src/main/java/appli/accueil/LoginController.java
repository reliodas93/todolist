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

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    private Button boutonInscription;

    @FXML
    private Button boutonMdpOubliee;

    @FXML
    private Button boutonConnexion;

    @FXML
    private TextField email;

    @FXML
    private Label labelErreur;

    @FXML
    private PasswordField mdp;

    @FXML
    void login(ActionEvent event) throws SQLException {
        String emailInput = email.getText().trim();
        String passwordInput = mdp.getText().trim();

        // Vérification des champs vides
        if (emailInput.isEmpty() || passwordInput.isEmpty()) {
            labelErreur.setText("Veuillez entrer vos identifiants.");
            labelErreur.setStyle("-fx-text-fill: red;");
            return;
        }

        // Récupération de l'utilisateur
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurParEmail(emailInput);

        // Vérification de l'existence de l'utilisateur et du mot de passe
        if (utilisateur == null) {
            labelErreur.setText("Aucun compte associé à cet email.");
            labelErreur.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!utilisateur.getMdp().equals(passwordInput)) {
            labelErreur.setText("Mot de passe incorrect.");
            labelErreur.setStyle("-fx-text-fill: red;");
            return;
        }

        // Connexion réussie
        labelErreur.setText("Connexion réussie !");
        labelErreur.setStyle("-fx-text-fill: blue;");

        // Redirection vers la page d'accueil
        try {
            StartApplication.changeScene("accueilView");
        } catch (IOException e) {
            e.printStackTrace();
            labelErreur.setText("Erreur de chargement de la page d'accueil.");
            labelErreur.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void retourInscription(ActionEvent event) {
        try {
            StartApplication.changeScene("Inscription"); // Assure-toi que ton fichier s'appelle bien Inscription.fxml
        } catch (IOException e) {
            e.printStackTrace();
            labelErreur.setText("Erreur de chargement de la page d'inscription.");
            labelErreur.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void boutonMdpOubliee(ActionEvent event) {
    }
}

