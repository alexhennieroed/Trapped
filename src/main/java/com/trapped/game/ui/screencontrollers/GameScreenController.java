package main.java.com.trapped.game.ui.screencontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import main.java.com.trapped.game.fxapp.TrappedGame;
import main.java.com.trapped.game.gamedata.Settings;
import main.java.com.trapped.game.model.Choice;
import main.java.com.trapped.game.model.Script;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * The controller for GameScreen.fxml
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class GameScreenController extends ScreenController {

    @FXML
    private ListView choicesListView;
    @FXML
    private Label descriptionTextLabel;

    private Script script;

    @Override
    public void setup() {
        if (myApp == null) {
            System.out.println("The app is null in GSC");
            System.exit(21);
        }
        if (myApp.getStoryHandler() == null) {
            System.out.println("The story handler is null in GSC.");
            System.exit(21);
        }
        script = myApp.getStoryHandler().getScript();
        updateScript();
    }

    @FXML
    public void saveGame() {
        try {
            FileOutputStream fout = new FileOutputStream(new File("D:\\savegame.ser"));
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(myApp.getStoryHandler());
            fout.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Failed to save file.");
            e.printStackTrace();
        }
    }

    @FXML
    public void makeChoice() {
        Choice choice = (Choice) choicesListView.getSelectionModel().getSelectedItem();
        if (choice != null) {
            choice.doAction();
        }
        myApp.getStoryHandler().progressStory(choice.getNextScript());
        script = myApp.getStoryHandler().getScript();
        updateScript();
    }

    /**
     * Updates the UI with the new script's data
     */
    private void updateScript() {
        descriptionTextLabel.setText(script.getDescriptionText());
        choicesListView.setItems(FXCollections.observableArrayList(script.getChoices()));
    }

}
