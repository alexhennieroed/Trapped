package main.java.com.trapped.game.ui.screencontrollers;

import main.java.com.trapped.game.fxapp.TrappedGame;

/**
 * A main class for screen controllers
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class ScreenController {

    protected TrappedGame myApp;

    /**
     * Sets the app value of the ScreenController
     * @param app the app for which to set the screen
     */
    public void setApp(TrappedGame app) {
        myApp = app;
        if (myApp == null) {
            System.out.println("App is null in SC\nNot sure how to fix this one, boss.");
            System.exit(1);
        }
    }

}
