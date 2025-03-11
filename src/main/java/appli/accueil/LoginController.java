package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class LoginController {

    
    @FXML
    private TextField email;


    @FXML
    private PasswordField mdp;

    @FXML
    private Label welcomeText;
    @FXML
    void Login(ActionEvent event) {
        String email = TextField.getText();
        String password = PasswordField.getText();

        System.out.println("Email: " + email);
        System.out.println("Mot de passe: " + password);

        if (email.equals("email@example.com") && password.equals("Azerty1234")) {
            System.out.println("Connexion réussie !");
            errorMessage.setText("Connexion réussie !");
        } else {
            System.out.println("Identifiants incorrects.");
            errorMessage.setText("Identifiants incorrects.");
        }
    }




}
