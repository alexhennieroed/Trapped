package ScriptCreator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Allows for easy creation of scripts
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class ScriptCreator extends Application {

    private Stage theStage;

    @Override
    public void start(Stage stage) {
        try {
            theStage = stage;
            theStage.setTitle("Script Creator");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ScriptCreator.class.getResource("ScriptCreator.fxml"));
            theStage.setScene(new Scene(loader.load()));
            theStage.show();
        } catch (IOException e) {
            System.out.println("Issue loading the fxml file");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
