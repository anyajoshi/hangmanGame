
import javax.swing.JFrame;
import java.awt.event.*;

public class Screen {

    public JFrame frame;
    public HangmanGame game;
    public String screenName;
    public int frameWidth = 700, frameHeight = 300;
    public ActionListener ae;

    public Screen(ActionListener ae, HangmanGame game, String title, String screenName) {
        this.game = game;
        frame = new JFrame(title);
        this.screenName = screenName;
        this.ae = ae;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public void showScreen(HangmanGame game) {
        // Base screen - needs to be overridden
    }

    public void closeScreen() {
        if (frame != null) {
            frame.dispose();
        }
    }

    public String handleUserAction(ActionEvent e) {
        return null;
    }

}
