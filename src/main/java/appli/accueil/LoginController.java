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
import session.SessionUtilisateur;
import java.io.IOException;
import java.sql.SQLException;
import org.springframework.security.crypto.bcrypt.BCrypt;

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

        // Récupération de l'utilisateur par email
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurParEmail(emailInput);

        // Vérification de l'existence de l'utilisateur
        if (utilisateur == null) {
            labelErreur.setText("Aucun compte associé à cet email.");
            labelErreur.setStyle("-fx-text-fill: red;");
            return;
        }

        // Vérification du mot de passe encodé
        if (!BCrypt.checkpw(passwordInput, utilisateur.getMdp())) {
            labelErreur.setText("Mot de passe incorrect.");
            labelErreur.setStyle("-fx-text-fill: red;");
            return;
        }

        // Connexion réussie
        System.out.println("Connexion réussie pour : " + utilisateur.getNom());
        labelErreur.setText("Connexion réussie !");
        labelErreur.setStyle("-fx-text-fill: blue;");

        // Sauvegarde de la session utilisateur
        SessionUtilisateur.getInstance().sauvegardeSession(utilisateur);

        // Redirection vers la page d'accueil après connexion réussie
        try {
            StartApplication.changeScene("PageAccueil"); // Page d'accueil après connexion
        } catch (IOException e) {
            e.printStackTrace();
            labelErreur.setText("Erreur de chargement de la page d'accueil.");
            labelErreur.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void retourInscription(ActionEvent event) {
        try {
            StartApplication.changeScene("Inscription"); // Redirection vers la page d'inscription
        } catch (IOException e) {
            e.printStackTrace();
            labelErreur.setText("Erreur de chargement de la page d'inscription.");
            labelErreur.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void boutonMdpOubliee(ActionEvent event) {
        // À implémenter plus tard
    }
}
