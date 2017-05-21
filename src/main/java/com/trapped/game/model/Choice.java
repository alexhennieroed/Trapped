package main.java.com.trapped.game.model;

import java.io.Serializable;

/**
 * An object representing a choice to be made
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Choice {

    private String name;
    private Action action;
    private String nextScript;

    /**
     * Creates a new choice object
     * @param name the name of the choice
     * @param action the action associated with the choice
     * @param nextScript the script triggered by this choice
     */
    public Choice(String name, Action action, String nextScript) {
        this.name = name;
        this.action = action;
        this.nextScript = nextScript;
    }

    /**
     * Creates a new choice object
     * @param name the name of the choice
     * @param action the action associated with the choice
     */
    public Choice(String name, Action action) {
        this(name, action, "0-0-00");
    }

    /**
     * Performs the action associated with this choice
     */
    public void doAction() {
        action.doAction();
    }

    /**
     * Returns the name of the choice
     * @return a string representing the name of the choice
     */
    public String getName() { return name; }

    /**
     * Returns the next script of the choice
     * @return a string representing the next script
     */
    public String getNextScript() { return nextScript; }

    @Override
    public String toString() { return name; }

}
