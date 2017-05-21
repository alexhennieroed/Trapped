package main.java.com.trapped.game.logic;

import javafx.collections.FXCollections;
import main.java.com.trapped.game.fxapp.TrappedGame;
import main.java.com.trapped.game.model.Character;
import main.java.com.trapped.game.model.Choice;
import main.java.com.trapped.game.model.Script;
import main.java.com.trapped.game.util.ScriptLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Drives the story forward and handles script loading and delivery
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class StoryHandler implements Serializable {

    private TrappedGame myApp;
    private ScriptLoader sl;
    private List<Choice> playerDecisions;
    private Script currentScript;
    private Character currentCharacter;
    private HashMap<String, Character> characterList;

    /**
     * Creates a new Story Handler object
     * @param app the app that is using the story handler
     */
    public StoryHandler(TrappedGame app) {
        this.myApp = app;
        if (myApp == null) {
            System.out.println("The app is null in StoryHandler init.");
            System.exit(21);
        }
        characterList = makeCharacters();
        sl = new ScriptLoader(myApp, this);
        currentScript = null;
        currentCharacter = null;
    }

    /**
     * Moves the story forward by intelligently selecting scripts
     * based on the player's decisions
     */
    public void progressStory(String newScript) {
        if (currentScript == null) {
            newScript = "0-0-00";
        }
        currentScript = sl.loadScript(newScript);
        currentCharacter = currentScript.getViewingCharacter();
    }

    /**
     * Returns the current script in the story
     * @return the current script
     */
    public Script getScript() { return currentScript; }

    /**
     * Returns the list of characters
     * @return a HashMap of the characters
     */
    public HashMap<String, Character> getCharacterList() { return characterList; }

    /**
     * Initializes the list of characters for the handler
     * @return a hash map of characters
     */
    private HashMap<String, Character> makeCharacters() {
        HashMap<String, Character> list = new HashMap<>();
        list.put("Luke", new Character("Luke"));
        list.put("Jerry", new Character("Jerry"));
        list.put("Sam", new Character("Sam"));
        list.put("Lindsey", new Character("Lindsey"));
        for (Character c : list.values()) {
            for (Character c2 : list.values()) {
                if (!c.equals(c2)) {
                    c.addRelationship(c2);
                }
            }
        }
        return list;
    }

    /**
     * Returns the list of choices the player has made
     * @return the list of choices
     */
    public List<Choice> getPlayerDecisions() { return playerDecisions; }

    /**
     * Adds a new choice to the list of player choices
     * @param c the choice to add
     */
    public void addPlayerDecision(Choice c) { playerDecisions.add(c); }

}
