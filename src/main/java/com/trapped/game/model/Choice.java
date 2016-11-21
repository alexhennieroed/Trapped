package main.java.com.trapped.game.model;

/**
 * An object representing a choice to be made
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Choice {

    private String name;
    private Action action;

    public Choice(String name, Action action) {
        this.name = name;
        this.action = action;
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

    @Override
    public String toString() { return name; }

}