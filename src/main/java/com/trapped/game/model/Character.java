package main.java.com.trapped.game.model;

import java.util.HashMap;

/**
 * Represents a character in the game
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Character {

    private String name;
    private HashMap<Character, Integer> relationships;
    private HashMap<Trait, Integer> traits;

    /**
     * Creates a character
     * @param name a string representing the name of the character
     */
    public Character(String name) {
        this.name = name;
        relationships = new HashMap<>();
        traits = new HashMap<>();
        for (Trait t : Trait.values()) {
            traits.put(t, 5);
        }
    }

    /**
     * Returns the name of the character
     * @return a string representing the name of the character
     */
    public String getName() { return name; }

    /**
     * Returns the list of relationships
     * @return a Hash Map representing the list of relationships
     */
    public HashMap<Character, Integer> getRelationships() { return relationships; }

    /**
     * Allows for the adjustment of a relationship with another character
     * @param person the character who the relationship is with
     * @param adjustment an integer value that changes the relationship level;
     *                   a positive value increases the relationship while a
     *                   negative value decreases it;
     *                   possible values are in the range of 0 to 10
     */
    public void adjustRelationship(Character person, int adjustment) {
        int change = relationships.get(person) + adjustment;
        if (change > 10) {
            change = 10;
        } else if (change < 0) {
            change = 0;
        }
        relationships.put(person, change);
    }

    /**
     * Adds a relationship to this character
     * @param person the person to add a relationship with
     */
    public void addRelationship(Character person) { relationships.put(person, 5); }

    /**
     * Returns the list of traits
     * @return a Hash Map representing the traits
     */
    public HashMap<Trait, Integer> getTraits() { return traits; }

    /**
     * Allows for the adjustment of a trait for the character
     * @param trait the trait to be adjusted
     * @param adjustment an integer value that changes the relationship level;
     *                   a positive value increases the relationship while a
     *                   negative value decreases it;
     *                   possible values are in the range of 0 to 10
     */
    public void adjustTrait(Trait trait, int adjustment) {
        int change = traits.get(trait) + adjustment;
        if (change > 10) {
            change = 10;
        } else if (change < 0) {
            change = 0;
        }
        traits.put(trait, change);
    }

    @Override
    public String toString() { return name; }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Character) {
            Character c = (Character) o;
            return this.getName().equals(c.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 17 * 7 * getName().hashCode();
    }

    /**
     * Represents a trait of a character
     */
    private enum Trait {

        CARING("Caring"),
        FUNNY("Funny"),
        SMART("Smart");

        private String name;

        /**
         * Creates a trait
         * @param name the name of the trait
         */
        Trait(String name) {
            this.name = name;
        }

        /**
         * Returns the name of the trait
         * @return a string representing the name of the trait
         */
        public String getName() { return name; }

        @Override
        public String toString() { return getName(); }

    }

}
