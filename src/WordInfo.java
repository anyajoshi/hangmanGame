public class WordInfo {

    private String word;
    private String description;

    public WordInfo(String word, String description) {
        this.word = word;
        this.description = description;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return this.description;
    }

    public String getWord() {
        return this.word;
    }

}
