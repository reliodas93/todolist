package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class StartApplication extends Application {

private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new
                FXMLLoader(StartApplication.class.getResource("accueil/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setTitle("Hello!");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void changeScene(String LoginViewfxml ) throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(StartApplication.class.getResource((LoginViewfxml  + "View.fxml")));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
