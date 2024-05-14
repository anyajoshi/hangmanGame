import java.util.ArrayList;

public class GameData {

    // Constructor()
    private ArrayList<WordCategory> categories;

    GameData() {

        // Load Words - Inheritence
        categories = new ArrayList<WordCategory>();
        categories.add(new Animals());
        categories.add(new Fruits());

        // Sort Based on Categories
        this.sortCategories();

    }

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

    public String[] getCategories() {
        String[] categoryNames = new String[this.categories.size()];
        int i = 0;
        for (WordCategory wc : this.categories) {
            categoryNames[i] = wc.getCategory();
            i++;
        }
        return categoryNames;
    }

    public WordInfo pickWord(String category) {

        WordCategory wordCategory = this.searchCategory(category);

        int randomIndex = (int) (Math.random() * wordCategory.getWordsWithDescription().size());
        return wordCategory.getWordsWithDescription().get(randomIndex);
    }

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