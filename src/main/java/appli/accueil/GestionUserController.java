package appli.accueil;

import appli.StartApplication;
import  javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.IOException;

public class GestionUserController {

        @FXML
        private Button buttonDeco;

        @FXML
        private TableView<?> tableauUser;

        @FXML
        private Button buttonRetour;

        @FXML
        void versConnexion(ActionEvent event) {
                try {
                        StartApplication.changeScene("Login"); // Redirection vers la page d'inscription
                } catch (IOException e) {
                        e.printStackTrace();

                }
        }


        @FXML
        void versTache(ActionEvent event) {
                try {
                        StartApplication.changeScene("PageAccueil"); // Redirection vers la page d'inscription
                } catch (IOException e) {
                        e.printStackTrace();

                }

        }


}
