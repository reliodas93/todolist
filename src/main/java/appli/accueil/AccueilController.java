package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AccueilController {

    @FXML
    private Button ajoutTacheButton;

    @FXML
    private ListView<String> listeTache;

    @FXML
    private Button supprimeTacheButton;

    @FXML
    private Button modifierTacheButton;

    @FXML
    private TextField tacheASaisir;

    private int indexTacheSelectionnee = -1;

    @FXML
    private void ajouterUneTache(ActionEvent event) {
        String tache = tacheASaisir.getText();
        if (tache != null && !tache.isEmpty()) {
            listeTache.getItems().add(tache);     // ajoute la tâche à la liste
            tacheASaisir.clear();                 // vide le champ après ajout
        }
    }

    @FXML
    private void supprimerUneTache(ActionEvent event) {
        String selection = listeTache.getSelectionModel().getSelectedItem();
        if (selection != null) {
            listeTache.getItems().remove(selection);  // supprime la tâche sélectionnée
        }
    }


     @FXML
    private void modifierUneTache(ActionEvent event) {
        String nouvelleTache = tacheASaisir.getText();
        if (indexTacheSelectionnee >= 0 && nouvelleTache != null && !nouvelleTache.isEmpty()) {
            listeTache.getItems().set(indexTacheSelectionnee, nouvelleTache);
            tacheASaisir.clear();
            listeTache.getSelectionModel().clearSelection();
            indexTacheSelectionnee = -1;
        }
    }
}
