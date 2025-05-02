package appli.accueil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import org.springframework.security.crypto.bcrypt.BCrypt;
import repository.UtilisateurRepository;
import model.Utilisateur;
import appli.StartApplication;
import java.io.IOException;
import java.sql.SQLException;

public class InscriptionController {
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    private Button boutonInscription;

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
    private Label labelErreur;

    @FXML
    void versLogin(ActionEvent event) {
        // 1. Récupérer les valeurs entrées par l'utilisateur
        String nom = Nom.getText().trim();
        String prenom = Prenom.getText().trim();
        String emailInput = email.getText().trim();
        String password = mdp.getText();
        String passwordConfirm = confirmationmdp.getText();


        // 2. Vérifier que tous les champs sont remplis
        if (nom.isEmpty() || prenom.isEmpty() || emailInput.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
            labelErreur.setText("Veuillez remplir tous les champs.");
            labelErreur.setStyle("-fx-text-fill: red;");
            return;
        }

        // 3. Vérifier si les mots de passe correspondent
        if (!password.equals(passwordConfirm)) {
            labelErreur.setText("Les mots de passe ne correspondent pas.");
            labelErreur.setStyle("-fx-text-fill: red;");
            return;
        }

        // 4. Vérifier si l'utilisateur existe déjà
        Utilisateur existingUser = null;
        try {
            existingUser = utilisateurRepository.getUtilisateurParEmail(emailInput);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (existingUser != null) {
            labelErreur.setText("Cet email est déjà utilisé.");
            labelErreur.setStyle("-fx-text-fill: red;");
            return;
        }

        // 5. Hachage sécurisé du mot de passe
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // 6. Création de l'utilisateur
        Utilisateur nouvelUtilisateur = new Utilisateur(0, nom, prenom, emailInput, hashedPassword);

        // 7. Enregistrement dans la base de données
        boolean isSaved = utilisateurRepository.ajouterUtilisateur(nouvelUtilisateur);
        if (isSaved) {
            labelErreur.setText("Inscription réussie !");
            labelErreur.setStyle("-fx-text-fill: green;");
            try {
                StartApplication.changeScene("Login"); // Redirection vers la page de connexion
            } catch (IOException e) {
                e.printStackTrace();
                labelErreur.setText("Erreur de chargement de la page de connexion.");
                labelErreur.setStyle("-fx-text-fill: red;");
            }
        } else {
            labelErreur.setText("Erreur lors de l'inscription.");
            labelErreur.setStyle("-fx-text-fill: red;");
        }
    }


}
