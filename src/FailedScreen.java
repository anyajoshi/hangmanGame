
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FailedScreen extends Screen {

    private JButton retryButton, learnMoreBtn;
    private JLabel gameFailedLabel, wordDescriptionLabel;

    public FailedScreen(ActionListener ae, HangmanGame game) {
        super(ae, game, "Failed", "Failed");
    }

    @Override
    public void showScreen(HangmanGame game) {
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
        learnMoreBtn.addActionListener(ae);
        panelCenterGrid.add(learnMoreBtn);

        retryButton = new JButton("Play Again");
        retryButton.addActionListener(ae);
        panelCenterGrid.add(retryButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public String handleUserAction(ActionEvent e) {
        if (e.getSource() == retryButton) {
            game.resetGame();
            return "CategorySelection";
        } else if (e.getSource() == learnMoreBtn) {

            final JDialog modalFrame = new JDialog(frame, game.getCurrentCategory() + " : " + game.getCurrentWord(),
                    true);
            modalFrame.setMinimumSize(new Dimension(500, 500));
            JPanel moreInfoPanel = new JPanel();
            moreInfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            wordDescriptionLabel = new JLabel();
            moreInfoPanel.add(wordDescriptionLabel);
            wordDescriptionLabel.setText(game.getCurrentWordDescription());

            // learnMoreLabel = new JLabel("Here is some more information about: " +
            // game.getCurrentWord());
            // moreInfoPanel.add(learnMoreLabel);

            modalFrame.getContentPane().add(moreInfoPanel);
            modalFrame.pack();
            modalFrame.setVisible(true);
        }
        return null;
    }

}
