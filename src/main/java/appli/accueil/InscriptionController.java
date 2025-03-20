package appli.accueil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class InscriptionController {

    @FXML
    private PasswordField confirmationmdp;

    @FXML
    private TextField email;

    @FXML
    private PasswordField mdp;

    @FXML
    private TextField Nom;

    @FXML
    private TextField Prenom;
    @FXML
    private PasswordField pass;
    @FXML
    private Label labelErreur;

    @FXML
    private Label welcomeText;

    void Inscription(ActionEvent event) {
        String nom = Nom.getText();
        String prenom = Prenom.getText();
        String emailInput = email.getText();
        String password = mdp.getText();
        String passInput = pass.getText();

        System.out.println("Nom = " + nom);
        System.out.println("Prenom = " + prenom);
        System.out.println("Email: " + emailInput);
        System.out.println("Mot de passe: " + password);
        System.out.println("pass : " + passInput);

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

    }
