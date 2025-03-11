package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {


    @FXML

    private TextField email;


    @FXML
    private PasswordField mdp;

    @FXML
    private Label welcomeText;
    private Label errorMessage;
    @FXML
    void Login(ActionEvent event) {
        String emailInput = email.getText();
        String password = mdp.getText();

        System.out.println("Email: " + email);
        System.out.println("Mot de passe: " + password);

        if (emailInput.equals("email@example.com") && password.equals("Azerty1234")) {
            System.out.println("Connexion réussie !");
            errorMessage.setText("Connexion réussie !");
        } else {
            System.out.println("Identifiants incorrects.");
            errorMessage.setText("Identifiants incorrects.");
        }
    }
    @FXML
    void goToInscription(ActionEvent event) {



    }




}
