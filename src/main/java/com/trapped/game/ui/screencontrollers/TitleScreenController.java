package main.java.com.trapped.game.ui.screencontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import main.java.com.trapped.game.model.Choice;
/**
 * Controls the functionality of TitleScreen.fxml
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class TitleScreenController extends ScreenController {

    @FXML
    private ListView menuChoicesListView;

    @FXML
    public void initialize() {
        ObservableList<Choice> menuChoices = FXCollections.observableArrayList(
                new Choice("New Game", () -> app.setScreen("GameScreen")),
                new Choice("Load Game", () -> System.out.println("Loading game...")),
                new Choice("Exit", () -> System.exit(21)));
        menuChoicesListView.setItems(menuChoices);
    }

    @FXML
    private void selectChoice() {
        Choice choice = (Choice) menuChoicesListView.getSelectionModel().getSelectedItem();
        if (choice != null) {
            choice.doAction();
        }
    }

}
