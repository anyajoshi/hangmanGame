
import java.awt.event.*;

public class GUI implements ActionListener {

    private Screen categorySelectionScreen;
    private Screen guessScreen;
    private Screen failedScreen;
    private Screen successScreen;
    private Screen s = null;

    private HangmanGame game;

    public GUI() {

        // Initialize Backend
        game = new HangmanGame();
        // showCategorySelectionScreen();
        categorySelectionScreen = new CategoryScreen(this, game);
        guessScreen = new GuessScreen(this, game);
        failedScreen = new FailedScreen(this, game);
        successScreen = new SuccessScreen(this, game);
        switchScreen("CategorySelection");
    }

    public static void main(String[] args) {
        new GUI();
    }

    private void switchScreen(String screenName) {

        if (screenName == null || (s != null && screenName.equals(s.getScreenName()))) {
            return;
        }

        if (s != null) {
            s.closeScreen();
        }

        if (screenName.equals("CategorySelection")) {
            s = categorySelectionScreen;
        } else if (screenName.equals("Guess")) {
            s = guessScreen;
        } else if (screenName.equals("Failed")) {
            s = failedScreen;
        } else if (screenName.equals("Success")) {
            s = successScreen;
        }
        s.showScreen(game);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switchScreen(s.handleUserAction(e));
    }

}
