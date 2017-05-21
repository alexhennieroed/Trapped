package main.java.com.trapped.game.util;

import javafx.collections.FXCollections;
import main.java.com.trapped.game.fxapp.TrappedGame;
import main.java.com.trapped.game.logic.StoryHandler;
import main.java.com.trapped.game.model.Action;
import main.java.com.trapped.game.model.Character;
import main.java.com.trapped.game.model.Choice;
import main.java.com.trapped.game.model.Script;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A utility class that loads scripts for the game
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class ScriptLoader {

    private TrappedGame app;
    private StoryHandler handler;
    private Scanner scanner;

    public ScriptLoader(TrappedGame app, StoryHandler handler) {
        this.app = app;
        this.handler = handler;
    }

    /**
     * Loads a script from the library
     * @param scriptName the name of the script file to load
     * @return the loaded script
     */
    public Script loadScript(String scriptName) {
        try {
            String workingDirectory = System.getProperty("user.dir");
            File file = new File(workingDirectory +
                    "/src/main/resources/scripts/Script" + scriptName + ".script");
            scanner = new Scanner(file);

            //Gather the header data
            String name = scanner.nextLine();
            scanner.nextLine();
            String charName = scanner.nextLine();
            Character scriptChar = handler.getCharacterList().get(charName);
            scanner.nextLine();
            String description = scanner.nextLine();
            scanner.nextLine();

            //Gather the choice data
            List<Choice> choices = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String choiceLine = scanner.nextLine();
                String[] firstSplit = choiceLine.split("\\|");
                String[] secondSplit = firstSplit[0].split(":");
                choices.add(new Choice(secondSplit[0],
                        processAction(secondSplit[1], scriptChar), firstSplit[1]));
            }

            return new Script(name, scriptChar, description,
                    FXCollections.observableArrayList(choices));
        } catch (IOException e) {
            System.out.println("Error finding the file.");
            e.printStackTrace();
        }
        return new Script();
    }

    /**
     * Processes the action data string to return an action
     * @param actionString the string with the action data
     * @param character the viewing character of the script
     * @return the action from the data
     */
    private Action processAction(String actionString, Character character) {
        if (actionString.contains("die")) {
            return () -> app.setScreen("GameOverScreen");
        }
        List<Action> actionList = new ArrayList<>();
        String[] actions = actionString.split("&");
        for (String act : actions) {
            Action action = null;
            String actionType = act.substring(0,3);
            String actionParams = act.substring(act.indexOf("(") + 1, act.indexOf(")"));
            String[] actParams = actionParams.split(",");
            if (actionType.equals("rel")) {
                Character paramChar = handler.getCharacterList().get(actParams[0]);
                action = () -> character.adjustRelationship(paramChar,
                        Integer.parseInt(actParams[1]));
            } else if (actionType.equals("trt")) {
                Character.Trait aTrait = null;
                for (Character.Trait t : Character.Trait.values()) {
                    if (t.getName().equals(actParams[0])) {
                        aTrait = t;
                    }
                }
                Character.Trait paramTrait = aTrait;
                action = () -> character.adjustTrait(paramTrait,
                        Integer.parseInt(actParams[1]));
            } else {
                System.out.println("Invalid action type provided.");
                return null;
            }
            actionList.add(action);
        }

        return new Action() {
            List<Action> actions = actionList;

            @Override
            public void doAction() {
                for (Action act : actions) {
                    act.doAction();
                }
            }
        };
    }

}
