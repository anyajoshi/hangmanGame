import java.net.URL;

/**
 * Extends WordCategory to create a new category of words related to Planets.
 */
public class Planets extends WordCategory {

    public Planets() {
        super("Planets");
        super.addWord("Mercury", "Closest to the Sun, smallest planet.");
        super.addWord("Venus", "Hottest planet, thick carbon dioxide atmosphere.");
        super.addWord("Earth", "Supports life, our home.");
        super.addWord("Mars", "Red planet, iron oxide surface.");
        super.addWord("Jupiter", "Largest planet, Great Red Spot storm.");
        super.addWord("Saturn", "Rings made of ice and dust.");
        super.addWord("Uranus", "Tilted sideways, unique rotation.");
        super.addWord("Neptune", "Farthest planet, discovered mathematically.");
    }

    /*
     * Retreives URL of icon representing Planets Category.
     *
     * @return - URL of Planets Category's icon.
     */
    public URL getCategoryIcon() {
        URL u = getClass().getResource("resources/planets.png");
        return u;
    }

}