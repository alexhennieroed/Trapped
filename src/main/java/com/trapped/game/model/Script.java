package main.java.com.trapped.game.model;

import javafx.collections.ObservableList;

/**
 * Represents an script for the game
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Script {

    private String name;
    private String descriptionText;
    private Character viewingCharacter;
    private ObservableList<Choice> choices;

    /**
     * Creates a new script
     * @param name the name of the script
     * @param descriptionText the dialogue and action occurring in the moment
     * @param choices the possible choices to make
     */
    public Script(String name, Character viewingCharacter, String descriptionText, ObservableList<Choice> choices) {
        this.name = name;
        this.viewingCharacter = viewingCharacter;
        this.descriptionText = descriptionText;
        this.choices = choices;
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
    public ObservableList<Choice> getChoices() { return choices; }

    /**
     * Returns the character who is the "I" in the script
     * @return the viewing character
     */
    public Character getViewingCharacter() { return viewingCharacter; }

}
