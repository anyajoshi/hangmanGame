import java.net.URL;

public class HangmanGame {
    private char[] discoveredChars;
    private String guessedLetters;
    private int remainingAttempts;
    private String currentCategory;
    private URL currentCategoryIcon;
    private String currentWord;
    private String currentWordDescription;
    private GameData gameData;

    public HangmanGame() {
        gameData = new GameData();
        this.guessedLetters = "";
        this.remainingAttempts = 6; // Default number of attempts
    }

    public String[] getCategories() {
        return gameData.getCategories();
    }

    public void chooseCategory(String category) {

        WordInfo currentWordInfo = gameData.pickWord(category);
        currentCategory = category;
        this.currentWord = currentWordInfo.getWord().toLowerCase();
        this.currentWordDescription = currentWordInfo.getDescription();
        this.discoveredChars = new char[currentWord.length()];
        for (int i = 0; i < discoveredChars.length; i++) {
            discoveredChars[i] = ' ';
        }
    }

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

    public boolean isWordDiscovered() {
        return this.currentWord.equals(String.valueOf(discoveredChars));
    }

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

    public String getGuessedLetters() {
        return guessedLetters;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public String getCurrentProgress() {
        return buildProgress(discoveredChars, 0, "");
    }

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

    public String getCurrentCategory() {
        return this.currentCategory;
    }

    public URL getCurrentCategoryIcon() {
        return this.currentCategoryIcon;
    }

    public String getCurrentWordDescription() {
        return this.currentWordDescription;
    }

    public String getCurrentWord() {
        return this.currentWord;
    }

    public String setCurrentCategory(String c) {
        return this.currentCategory = c;
    }

}
