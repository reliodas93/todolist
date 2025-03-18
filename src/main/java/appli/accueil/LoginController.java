package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.io.IOException;


public class LoginController {

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

    @FXML
    void Login(ActionEvent event) {
        String emailInput = email.getText();
        String password = mdp.getText();

        System.out.println("Email: " + emailInput);
        System.out.println("Mot de passe: " + password);

        if (emailInput.equals("email@example.com") && password.equals("Azerty1234")) {
            System.out.println("Connexion réussie !");
            labelErreur.setText("Connexion réussie !");
            labelErreur.setStyle("-fx-text-fill: green;");
        } else {
            System.out.println("Identifiants incorrects.");
            labelErreur.setText("Identifiants incorrects.");
            labelErreur.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void retourInscription(ActionEvent event) {
        try {
            StartApplication.changeScene("accueil/inscriptionView");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
