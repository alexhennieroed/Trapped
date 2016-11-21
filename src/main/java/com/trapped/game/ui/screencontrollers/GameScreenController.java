package main.java.com.trapped.game.ui.screencontrollers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.java.com.trapped.game.model.Choice;
import main.java.com.trapped.game.model.Script;

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

    @FXML
    public void initialize() {
        script = app.getStoryHandler().getScript();
        updateScript();
    }

    @FXML
    public void makeChoice() {
        Choice choice = (Choice) choicesListView.getSelectionModel().getSelectedItem();
        if (choice != null) {
            choice.doAction();
        }
        app.getStoryHandler().progressStory();
        script = app.getStoryHandler().getScript();
        updateScript();
    }

    private void updateScript() {
        descriptionTextLabel.setText(script.getDescriptionText());
        choicesListView.setItems(script.getChoices());
    }

}
