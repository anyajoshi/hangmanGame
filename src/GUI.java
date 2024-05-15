
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.*;

/**
 * Creates the graphical user interface for the hangman game.
 */
public class GUI implements ActionListener {
    private JFrame frame;
    private JTextField inputField;

    private JButton guessButton, pickCategoryButton, retryButton, learnMoreBtn;
    private JLabel wordLabel, wordText, categoryLabel, categoryText, remaingAttemptsLabel,
            remaingAttemptsText, guessedLettersLabel, guessedLettersText, gameSuccessLabel, gameFailedLabel,
            hangmanImageLabel, wordDescriptionLabel, categoryIconLabel;
    private JComboBox categoryList;
    private int frameWidth = 700, frameHeight = 300;

    private HangmanGame game;

    /**
     * Constructs the GUI object and initializes the backend Hangman game.
     */

    public GUI() {

        // Initialize Backend
        game = new HangmanGame();
        showCategorySelectionScreen();

    }

    /**
     * The main method to start the Hangman game GUI.
     */
    public static void main(String[] args) {
        new GUI();
    }

    /**
     * Displays the category selection screen.
     */
    private void showCategorySelectionScreen() {

        frame = new JFrame("Hangman Game: Select a Category");
        String[] categories = game.getCategories();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.add(new JLabel("Please select the desired category and clik on the 'Go' button to play"));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelSouth = new JPanel();
        panelSouth.add(new JLabel("Enjoy"));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel panelCenterGrid = new JPanel();
        panelCenterGrid.setLayout(new GridLayout(1, 2, 5, 5));
        panelCenter.add(panelCenterGrid);

        JPanel panelCenterLeft = new JPanel();
        JPanel panelCenterRight = new JPanel();
        panelCenterGrid.add(panelCenterLeft);
        panelCenterGrid.add(panelCenterRight);

        categoryLabel = new JLabel("Category");
        panelCenterLeft.add(categoryLabel);

        categoryList = new JComboBox(categories);
        panelCenterLeft.add(categoryList);

        pickCategoryButton = new JButton("Go");
        pickCategoryButton.addActionListener(this);
        panelCenterRight.add(pickCategoryButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    /**
     * Displays the word guessing screen for the given category.
     * 
     * @param category - The given category.
     */
    private void showWordGuessScreen(String category) {
        frame.dispose();

        this.game.chooseCategory(category);

        frame = new JFrame("Hangman Game: Guess Word");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth + 300, frameHeight + 300);
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
        categoryText = new JLabel(category);
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
        guessButton.addActionListener(this);
        inputPanel.add(guessButton);

        JPanel panelCenterCategoryIcon = new JPanel();
        categoryIconLabel = new JLabel();
        // categoryIconLabel.setMinimumSize(new Dimension(40, 40));
        // categoryIconLabel.setPreferredSize(new Dimension(40, 40));
        // categoryIconLabel.setMaximumSize(new Dimension(40, 40));
        panelCenter.add(categoryIconLabel);
        panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        // frame.add(panelCenterCategoryIcon, BorderLayout.CENTER);

        setGameState();

        frame.setVisible(true);

    }

    /**
     * Displays the game success screen when the word is correctly guessed.
     */
    private void showGameSuccessScreen() {
        frame.dispose();

        frame = new JFrame("Hangman Game: Congratulations! You did it");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.add(new JLabel("Success"));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelSouth = new JPanel();
        panelSouth.add(new JLabel("Your current streak is - Who is counting right?"));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelCenter = new JPanel();
        JPanel panelCenterGrid = new JPanel();
        panelCenterGrid.setLayout(new GridLayout(4, 1, 5, 5));
        panelCenter.add(panelCenterGrid);

        gameSuccessLabel = new JLabel("You correctly guessed the word: " + game.getCurrentWord());
        panelCenterGrid.add(gameSuccessLabel);

        learnMoreBtn = new JButton("Learn more about: " + game.getCurrentWord());
        learnMoreBtn.addActionListener(this);
        panelCenterGrid.add(learnMoreBtn);

        retryButton = new JButton("Play Again");
        retryButton.addActionListener(this);
        panelCenterGrid.add(retryButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);

        frame.setVisible(true);

    }

    /**
     * Displays the game failure screen when the correct word is not guessed within
     * the given tries.
     */
    private void showGameFailedcreen() {
        frame.dispose();

        frame = new JFrame("Hangman Game: Better Luck Next Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.add(new JLabel("Tough Luck"));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelSouth = new JPanel();
        panelSouth.add(new JLabel("Keep trying"));
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelCenter = new JPanel();
        JPanel panelCenterGrid = new JPanel();
        panelCenterGrid.setLayout(new GridLayout(4, 1, 5, 5));
        panelCenter.add(panelCenterGrid);

        gameFailedLabel = new JLabel("You could not guess it this time. The word was " + game.getCurrentWord());
        panelCenterGrid.add(gameFailedLabel);

        learnMoreBtn = new JButton("Learn more about: " + game.getCurrentWord());
        learnMoreBtn.addActionListener(this);
        panelCenterGrid.add(learnMoreBtn);

        retryButton = new JButton("Play Again");
        retryButton.addActionListener(this);
        panelCenterGrid.add(retryButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    /**
     * Updates the game state and checks if satisfied, the game completion
     * conditions.
     */
    private void setGameState() {
        setDiscoveredWordText();
        setCategoryText();
        setRemaingAttemptsText();
        setGuessedLettersText();
        setHangmanImage();
        setCategoryIcon();

        if (game.isWordDiscovered()) {
            showGameSuccessScreen();
        } else if (game.getRemainingAttempts() == 0) {
            showGameFailedcreen();
        }
    }

    /**
     * Sets the text displaying the discovered word.
     */
    private void setDiscoveredWordText() {
        wordText.setText(game.getCurrentProgress());
    }

    /**
     * Sets the text displaying the category.
     */
    private void setCategoryText() {
        categoryText.setText(game.getCurrentCategory());
    }

    /**
     * Sets the text displaying the remaining attempts.
     */
    private void setRemaingAttemptsText() {
        remaingAttemptsText.setText(String.valueOf(game.getRemainingAttempts()));
    }

    /**
     * Sets the text displaying the already guessed letters.
     */
    private void setGuessedLettersText() {
        guessedLettersText.setText(game.getGuessedLetters());
    }

    /**
     * Sets the hangman image based on the number of failed attempts.
     */
    private void setHangmanImage() {
        int failedAttempts = 6 - game.getRemainingAttempts();
        URL u = getClass().getResource("resources/hm" + failedAttempts + ".jpeg");
        hangmanImageLabel.setIcon(new ImageIcon(u));

    }

    /**
     * Sets the category icon.
     */
    private void setCategoryIcon() {
        URL u = game.getCurrentCategoryIcon();
        categoryIconLabel.setIcon(new ImageIcon(u));
    }

    /**
     * Manages output of button click events.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pickCategoryButton) {
            showWordGuessScreen((String) categoryList.getSelectedItem());
        } else if (e.getSource() == guessButton) {
            game.guess(inputField.getText().toLowerCase().charAt(0));
            inputField.setText(null);
            setGameState();
        } else if (e.getSource() == retryButton) {
            game.resetGame();
            showCategorySelectionScreen();
        } else if (e.getSource() == learnMoreBtn) {

            final JDialog modalFrame = new JDialog(frame, game.getCurrentCategory() + " : " + game.getCurrentWord(),
                    true);
            modalFrame.setMinimumSize(new Dimension(500, 500));
            JPanel moreInfoPanel = new JPanel();
            moreInfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            wordDescriptionLabel = new JLabel();
            moreInfoPanel.add(wordDescriptionLabel);
            wordDescriptionLabel.setText(game.getCurrentWordDescription());

            modalFrame.getContentPane().add(moreInfoPanel);
            modalFrame.pack();
            modalFrame.setVisible(true);
        }
    }

}
