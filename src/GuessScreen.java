import java.net.URL;

import javax.swing.*;
import java.awt.event.*;

import java.awt.*;

public class GuessScreen extends Screen {

    private JTextField inputField;

    private JButton guessButton;
    private JLabel wordLabel, wordText, categoryLabel, categoryText, remaingAttemptsLabel,
            remaingAttemptsText, guessedLettersLabel, guessedLettersText, hangmanImageLabel;

    public GuessScreen(ActionListener ae, HangmanGame game) {
        super(ae, game, "Guess Word", "Guess");
    }

    @Override
    public void showScreen(HangmanGame game) {
        this.game.chooseCategory(game.getCurrentCategory());

        frame = new JFrame("Hangman Game: Guess Word");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight + 300);
        frame.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.add(new JLabel("Guess an alphabet and press 'Guess'"));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelSouth = new JPanel();
        panelSouth.add(new JLabel("Don't let him hang"));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelCenter = new JPanel();
        JPanel panelCenterGrid = new JPanel();
        panelCenterGrid.setLayout(new GridLayout(1, 2, 5, 5));
        panelCenter.add(panelCenterGrid);

        JPanel panelCenterLeft = new JPanel();
        JPanel panelCenterRight = new JPanel();
        panelCenterRight.setLayout(new GridLayout(11, 1, 5, 5));
        panelCenterGrid.add(panelCenterLeft);
        panelCenterGrid.add(panelCenterRight);

        // HM Image
        hangmanImageLabel = new JLabel();
        panelCenterLeft.add(hangmanImageLabel);

        // Category
        JPanel categoryPanel = new JPanel();
        panelCenterRight.add(categoryPanel);
        categoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        categoryLabel = new JLabel("Category:");
        categoryPanel.add(categoryLabel);
        categoryText = new JLabel(game.getCurrentCategory());
        categoryPanel.add(categoryText);

        // Guessed Word
        JPanel guessedWordPanel = new JPanel();
        panelCenterRight.add(guessedWordPanel);
        guessedWordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        wordLabel = new JLabel("Guessed Word:");
        guessedWordPanel.add(wordLabel);
        wordText = new JLabel("");
        guessedWordPanel.add(wordText);

        // remaining Attempts
        JPanel remainingAttemptsPanel = new JPanel();
        panelCenterRight.add(remainingAttemptsPanel);
        remainingAttemptsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        remaingAttemptsLabel = new JLabel("Remaining Attempts:");
        remainingAttemptsPanel.add(remaingAttemptsLabel);
        remaingAttemptsText = new JLabel("");
        remainingAttemptsPanel.add(remaingAttemptsText);

        // Letters Guessed So Far
        JPanel guessedSoFarPanel = new JPanel();
        panelCenterRight.add(guessedSoFarPanel);
        guessedSoFarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        guessedLettersLabel = new JLabel("Letters Guessed:");
        guessedSoFarPanel.add(guessedLettersLabel);
        guessedLettersText = new JLabel("");
        guessedSoFarPanel.add(guessedLettersText);

        // Input
        JPanel inputPanel = new JPanel();
        panelCenterRight.add(inputPanel);
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputField = new JTextField(2);
        inputPanel.add(inputField);
        guessButton = new JButton("Guess");
        guessButton.addActionListener(ae);
        inputPanel.add(guessButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);

        int state = setGameState();
        // Ignore state, because initially, the state will always be 0

        frame.setVisible(true);
    }

    private int setGameState() {
        setDiscoveredWordText();
        setCategoryText();
        setRemaingAttemptsText();
        setGuessedLettersText();
        setHangmanImage();

        if (game.isWordDiscovered()) {
            return 1;
        } else if (game.getRemainingAttempts() == 0) {
            return -1;
        }
        return 0;
    }

    private void setDiscoveredWordText() {
        wordText.setText(game.getCurrentProgress());
    }

    private void setCategoryText() {
        categoryText.setText(game.getCurrentCategory());
    }

    private void setRemaingAttemptsText() {
        remaingAttemptsText.setText(String.valueOf(game.getRemainingAttempts()));
    }

    private void setGuessedLettersText() {
        guessedLettersText.setText(game.getGuessedLetters());
    }

    private void setHangmanImage() {
        int failedAttempts = 6 - game.getRemainingAttempts();
        URL u = getClass().getResource("resources/hm" + failedAttempts + ".jpeg");
        hangmanImageLabel.setIcon(new ImageIcon(u));
    }

    public String handleUserAction(ActionEvent e) {
        if (e.getSource() == guessButton) {
            game.guess(inputField.getText().toLowerCase().charAt(0));
            inputField.setText(null);
            int state = setGameState();
            if (state == 1) {
                return "Success";
            } else if (state == -1) {
                return "Failed";
            }
        }
        return "Guess";
    }

}
