import java.net.URL;
import java.util.ArrayList;

/**
 * The WordCategory class represents a category of words along with their
 * descriptions.
 */
class WordCategory {

    private String category;
    private ArrayList<WordInfo> wordsWithDescription;

    /**
     * Constructs a new WordCategory object with the specified category name.
     *
     * @param category - the name of the category
     */

    public WordCategory(String category) {
        this.category = category;
        this.wordsWithDescription = new ArrayList<WordInfo>();
    }

    /**
     * Adds a new word with its description to this category.
     *
     * @param word            - the word that needs to be added
     * @param wordDescription - the description of the word
     */
    public void addWord(String word, String wordDescription) {
        wordsWithDescription.add(new WordInfo(word, wordDescription, this));
    }

    /**
     * Returns the name of the category.
     *
     * @return - the name of the category
     */

    public String getCategory() {
        return this.category;
    }

    /**
     * Returns the list of WordInfo objects containing words along with their
     * descriptions in this category.
     *
     * @return - a list of WordInfo objects
     */
    public ArrayList<WordInfo> getWordsWithDescription() {
        return this.wordsWithDescription;
    }

    /**
     * Retrieves the URL of the icon associated with a given category.
     *
     * @return - the URL of the given category icon
     */

    public URL getCategoryIcon() {
        URL u = getClass().getResource("resources/general.jpeg");
        return u;
    }
}
