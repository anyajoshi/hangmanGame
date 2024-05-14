import java.util.ArrayList;

public class WordCategory {

    private String category;
    private ArrayList<WordInfo> wordsWithDescription;

    public WordCategory(String category) {
        this.category = category;
        this.wordsWithDescription = new ArrayList<WordInfo>();
    }

    public void addWord(String word, String wordDescription) {
        wordsWithDescription.add(new WordInfo(word, wordDescription));
    }

    public String getCategory() {
        return this.category;
    }

    public ArrayList<WordInfo> getWordsWithDescription() {
        return this.wordsWithDescription;
    }

}
