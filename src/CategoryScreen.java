import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;

import java.awt.*;

public class CategoryScreen extends Screen {

    private JButton pickCategoryButton;
    private JLabel categoryLabel;
    private JComboBox categoryList;
    private int frameWidth = 700, frameHeight = 300;

    public CategoryScreen(ActionListener ae, HangmanGame game) {
        super(ae, game, "Select a Category", "CategorySelection");
    }

    @Override
    public void showScreen(HangmanGame game) {
        frame.dispose();
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
        pickCategoryButton.addActionListener(ae);
        panelCenterRight.add(pickCategoryButton);

        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public String handleUserAction(ActionEvent e) {
        if (e.getSource() == pickCategoryButton) {
            String categorySelected = (String) categoryList.getSelectedItem();
            this.game.setCurrentCategory(categorySelected);
            return "Guess";
        }
        return null;
    }

}
