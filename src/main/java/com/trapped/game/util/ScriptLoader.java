package main.java.com.trapped.game.util;

import javafx.collections.FXCollections;
import main.java.com.trapped.game.fxapp.TrappedGame;
import main.java.com.trapped.game.model.Character;
import main.java.com.trapped.game.model.Choice;
import main.java.com.trapped.game.model.Script;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * A utility class that loads scripts for the game
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class ScriptLoader {

    private TrappedGame app;
    private Scanner scanner;

    public ScriptLoader(TrappedGame app) {
        this.app = app;
    }

    /**
     * Loads a script from the library
     * @param scriptName the name of the script file to load
     * @return the loaded script
     */
    public Script loadScript(String scriptName) {
        try {
            Script script;
            String[] brokenName = scriptName.split("-");
            String workingDirectory = System.getProperty("user.dir");
            File file = new File(workingDirectory + "/src/main/resources/scripts/Chapter" +
                    brokenName[0] + "/Scene" + brokenName[1] + "/Script" + scriptName + ".script");
            scanner = new Scanner(file);
        } catch (IOException e) {
            System.out.println("Error finding the file.");
            e.printStackTrace();
        }
        return new Script("Default", app.getStoryHandler().getCharacterList().get("Luke"), "Default Text",
                FXCollections.observableArrayList(new Choice("Default Action", () -> app.setScreen("TitleScreen"))));
    }

}
