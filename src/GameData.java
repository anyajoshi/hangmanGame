import java.util.ArrayList;

/**
 * Handles the game data including the words, word categories and word
 * selection.
 */
public class GameData {

    private ArrayList<WordCategory> categories;

    /**
     * Constructs a GameData object and initializes word categories.
     */
    GameData() {

        // Load Words - Inheritence
        categories = new ArrayList<WordCategory>();
        categories.add(new Animals());
        categories.add(new Fruits());
        categories.add(new Countries());
        categories.add(new Disney());
        categories.add(new JavaTerms());
        categories.add(new Planets());

        // Sort Based on Categories
        this.sortCategories();

    }

    /**
     * Sorts the word categories alphabetically from a-z.
     */
    private void sortCategories() {
        int n = categories.size();
        int i, j;
        WordCategory temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (categories.get(j).getCategory().compareTo(categories.get(j + 1).getCategory()) > 0) {

                    // Swap arr[j] and arr[j+1]
                    temp = categories.get(j);
                    categories.set(j, categories.get(j + 1));
                    categories.set((j + 1), temp);
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }

    }

    /**
     * Returns the names of all available categories.
     *
     * @return - An array of the category names.
     */
    public String[] getCategories() {
        String[] categoryNames = new String[this.categories.size()];
        int i = 0;
        for (WordCategory wc : this.categories) {
            categoryNames[i] = wc.getCategory();
            i++;
        }
        return categoryNames;
    }

    /**
     * Randomly selects a word from the specified category and returns a WordInfo
     * object of the word.
     *
     * @param category - The specified category.
     * @return - A WordInfo object representing the chosen word.
     */

    public WordInfo pickWord(String category) {

        WordCategory wordCategory = this.searchCategory(category);

        int randomIndex = (int) (Math.random() * wordCategory.getWordsWithDescription().size());
        return wordCategory.getWordsWithDescription().get(randomIndex);
    }

    /**
     * Searches for a category by the given name.
     *
     * @param - category The name of the category to search for.
     * @return - The WordCategory object corresponding to the specified category
     *         name.
     */

    private WordCategory searchCategory(String category) {
        WordCategory wc = null;
        int i = 0;
        while (wc == null) {
            if (this.categories.get(i).getCategory().equals(category)) {
                wc = this.categories.get(i);
            }
            i++;
        }
        return wc;
    }

}