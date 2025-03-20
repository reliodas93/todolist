package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class StartApplication extends Application {
     static Stage mainStage;
    static Scene mainScene;

    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("accueil/loginView.fxml"));
        mainScene = new Scene(fxmlLoader.load(), 500,500);
        mainStage.setTitle("Hello!");
        mainStage.setScene(mainScene);
        mainStage.show();
    }
    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String nomDuFichierFxml) throws IOException {

        FXMLLoader fxmlLoader = new
FXMLLoader(StartApplication.class.getResource("accueil/"+nomDuFichierFxml + "View.fxml"));
        mainScene  = new Scene(fxmlLoader.load());
        mainStage.setScene(mainScene);

    }
}
