package main.java.com.trapped.game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents an script for the game
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Script implements Serializable {

    private String name;
    private String descriptionText;
    private Character viewingCharacter;
    private List<Choice> choices;

    /**
     * Creates a new script
     * @param name the name of the script
     * @param descriptionText the dialogue and action occurring in the moment
     * @param choices the possible choices to make
     */
    public Script(String name, Character viewingCharacter, String descriptionText, List<Choice> choices) {
        this.name = name;
        this.viewingCharacter = viewingCharacter;
        this.descriptionText = descriptionText;
        this.choices = choices;
    }

    /**
     * No parameter script constructor
     */
    public Script() {
        this("Default", new Character("Default"), "Default Text",
                new ArrayList<>(Arrays.asList(new Choice("Default Action",
                        () -> System.out.println("Default")))));
    }

    /**
     * Returns the name of the script
     * @return a string representing the name
     */
    public String getName() { return name; }

    /**
     * Returns the description text for the script
     * @return a string representing the description text
     */
    public String getDescriptionText() { return descriptionText; }

    /**
     * Returns the choices for the script
     * @return an observable list with the choices
     */
    public List<Choice> getChoices() { return choices; }

    /**
     * Returns the character who is the "I" in the script
     * @return the viewing character
     */
    public Character getViewingCharacter() { return viewingCharacter; }

}
