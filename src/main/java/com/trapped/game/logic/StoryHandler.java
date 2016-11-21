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

    private TrappedGame app;
    private ScriptLoader sl;
    private Script currentScript;
    private Character currentCharacter;
    private HashMap<String, Character> characterList;

    public StoryHandler(TrappedGame app) {
        this.app = app;
        characterList = makeCharacters();
        sl = new ScriptLoader(app);
        currentScript = sl.loadScript("0-0-00");
        currentCharacter = currentScript.getViewingCharacter();
    }

    /**
     * Moves the story forward by intelligently selecting scripts
     */
    public void progressStory() {
        //TODO
    }

    /**
     * Returns the current script in the story
     * @return the current script
     */
    public Script getScript() { return currentScript; }

    public HashMap<String, Character> getCharacterList() { return characterList; }

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

}
