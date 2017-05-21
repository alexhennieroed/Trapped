package main.java.com.trapped.game.fxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.trapped.game.gamedata.Settings;
import main.java.com.trapped.game.logic.StoryHandler;
import main.java.com.trapped.game.ui.screencontrollers.ScreenController;
import main.java.com.trapped.game.util.ScriptLoader;

import java.io.IOException;

/**
 * The main class of the game; initializes the UI and the game loop
 */
public class TrappedGame extends Application {

    private Stage mainStage;
    private StoryHandler handler;
    private ScriptLoader sl;

    @Override
    public void start(Stage stage) {
        handler = new StoryHandler(this);
        sl = new ScriptLoader(this, handler);
        mainStage = stage;
        mainStage.setTitle(Settings.GAME_TITLE);
        mainStage.setWidth(800);
        mainStage.setMaxWidth(800);
        mainStage.setMinWidth(800);
        mainStage.setHeight(600);
        mainStage.setMaxHeight(600);
        mainStage.setMinHeight(600);
        setScreen("TitleScreen");
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Sets the current screen of the stage to the screen specified
     * @param screenName the name of the screen to be loaded
     */
    public void setScreen(String screenName) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TrappedGame.class.getResource("../ui/screens/" + screenName + ".fxml"));
            mainStage.setScene(new Scene(loader.load()));
            ScreenController controller = loader.getController();
            controller.setApp(this);
            controller.setup();
        } catch (IOException e) {
            System.out.println("Error loading screen: " + screenName);
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        } catch (IllegalStateException i) {
            System.out.println("Error in the state.");
            System.out.println(i.getMessage());
            i.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Returns the story handler
     * @return the story handler
     */
    public StoryHandler getStoryHandler() { return handler; }

    /**
     * Returns the script loader
     * @return the script loader
     */
    public ScriptLoader getSl() { return sl; }

}
