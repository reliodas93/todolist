package appli.accueil;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.Utilisateur;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionUserController implements Initializable {
        @FXML
        private TableView<Utilisateur> tableauUser;
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            // Code d'initialisation exécuté automatiquement au chargement de la vue
        }
    }


