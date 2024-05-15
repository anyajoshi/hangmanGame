import java.net.URL;

/**
 * Represents the playing class Hangman Game.
 */
public class HangmanGame {
    private char[] discoveredChars;
    private String guessedLetters;
    private int remainingAttempts;
    private String currentCategory;
    private URL currentCategoryIcon;
    private String currentWord;
    private String currentWordDescription;
    private GameData gameData;

    /**
     * Constructs a HangmanGame object.
     */
    public HangmanGame() {
        gameData = new GameData();
        this.guessedLetters = "";
        this.remainingAttempts = 6; // Default number of attempts
    }

    /**
     * Returns all the available categories for the game.
     *
     * @return - An array of category names.
     */
    public String[] getCategories() {
        return gameData.getCategories();
    }

    /**
     * Chooses a category for the game and initializes game parameters.
     *
     * @param category - The chosen category.
     */
    public void chooseCategory(String category) {

        WordInfo currentWordInfo = gameData.pickWord(category);
        currentCategory = category;
        this.currentWord = currentWordInfo.getWord().toLowerCase();
        this.currentWordDescription = currentWordInfo.getDescription();
        this.discoveredChars = new char[currentWord.length()];
        for (int i = 0; i < discoveredChars.length; i++) {
            discoveredChars[i] = ' ';
        }
        currentCategoryIcon = currentWordInfo.getCategory().getCategoryIcon();

    }

    /**
     * Checks if the guessed letter matches any letter in the current asked word.
     *
     * @param letter - The letter guessed by the player.
     * @return - True if the guessed letter is matched with a letter in the asked
     *         word, otherwise false.
     */

    public boolean guess(char letter) {
        boolean isCorrect = false;
        guessedLetters += letter;
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == letter) {
                discoveredChars[i] = letter;
                isCorrect = true;
            }
        }
        if (!isCorrect) {
            remainingAttempts--;
        }
        return isCorrect;
    }

    /**
     * Checks if the word has been completely filled correctly.
     *
     * @return - True if the word has been completely discovered, otherwise false.
     */
    public boolean isWordDiscovered() {
        return this.currentWord.equals(String.valueOf(discoveredChars));
    }

    /**
     * Resets the game to its initial settings to play again.
     */
    public void resetGame() {
        for (int i = 0; i < discoveredChars.length; i++) {
            discoveredChars[i] = ' ';
        }
        guessedLetters = "";
        remainingAttempts = 6;
        currentCategory = "";
        currentWord = "";
        currentWordDescription = "";
        discoveredChars = null;
    }

    /**
     * Returns the letters guessed by the player.
     *
     * @return - The letters guessed by the player.
     */
    public String getGuessedLetters() {
        return guessedLetters;
    }

    /**
     * Returns the remaining attempts allowed for the player in the game.
     *
     * @return - The number remaining attempts.
     */
    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    /**
     * Returns the user's current progress of the game.
     *
     * @return - A string representing the current progress.
     */
    public String getCurrentProgress() {
        return buildProgress(discoveredChars, 0, "");
    }

    /**
     * Builds the progress string recursively by displaying characters guessed and
     * spaces.
     *
     * @param discoveredChars - The characters discovered so far.
     * @param index           - The current index.
     * @param displayString   - The current display string being built.
     * @return - The progress string.
     */
    // Build Progress String recursively
    private static String buildProgress(char[] discoveredChars, int index, String displayString) {
        // Base case: if the index is equal to the length of the array, return the
        // displayString.
        if (index == discoveredChars.length) {
            return displayString;
        }

        // Add a space before each character except the first.
        if (index > 0) {
            displayString += " ";
        }

        // Check the current character and update displayString accordingly.
        if (discoveredChars[index] != ' ') {
            displayString += " " + discoveredChars[index] + " ";
        } else {
            displayString += "___";
        }

        // Recursive call with the next index.
        return buildProgress(discoveredChars, index + 1, displayString);
    }

    /**
     * Returns the current category being used in the game.
     *
     * @return - The current category.
     */

    public String getCurrentCategory() {
        return this.currentCategory;
    }

    /**
     * Returns the URL of the icon representing the current category.
     *
     * @return - The URL of the category icon.
     */
    public URL getCurrentCategoryIcon() {
        return this.currentCategoryIcon;
    }

    /**
     * Returns the description of the current word being used in the game.
     *
     * @return - The description of the current word.
     */
    public String getCurrentWordDescription() {
        return this.currentWordDescription;
    }

    /**
     * Returns the current word being used in the game.
     *
     * @return - The current word.
     */
    public String getCurrentWord() {
        return this.currentWord;
    }

}
