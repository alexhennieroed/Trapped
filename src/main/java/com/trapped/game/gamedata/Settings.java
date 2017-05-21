package main.java.com.trapped.game.gamedata;

/**
 * Holds the settings data for the game
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Settings {

    //Information about the game
    public static final String GAME_TITLE = "Trapped";
    public static final String GAME_AUTHOR = "Alexander Hennie-Roed";
    public static final String SAVE_LOCATION = ClassLoader.getSystemClassLoader().getResource(".").getPath();

    //Important game data
    public static final String[] CHARACTERS_ARRAY = {
            "Luke", "Jerry", "Sam", "Lindsey"
    };

}
