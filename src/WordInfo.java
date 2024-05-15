
/**
 * Holds information about a word, including the word, the word's description,
 * and the category it belongs to.
 */
public class WordInfo {

    private String word;
    private String description;
    private WordCategory category;

    /**
     * Constructs a WordInfo object with the given word, description, and category.
     *
     * @param word        - The given word.
     * @param description - The description of the given word.
     * @param category    - The category to which this word belongs.
     * 
     */
    public WordInfo(String word, String description, WordCategory category) {
        this.word = word;
        this.description = description;
        this.category = category;

    }

    /**
     * Sets the description of a word to the description variable.
     *
     * @param description - The description of a word.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the word to the word variable.
     *
     * @param - word The word.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Returns the description of the word.
     *
     * @return - The description of the word.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the word.
     *
     * @return - The word.
     */
    public String getWord() {
        return this.word;
    }

    /**
     * Returns the category to which the word belongs.
     *
     * @return - The category of the word.
     */
    public WordCategory getCategory() {
        return this.category;
    }
}
