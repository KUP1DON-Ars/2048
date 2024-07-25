import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameField {

    public static JLabel [][] labels;

    public GameField() {
        labels = new JLabel[Config.nubmerClellr][Config.nubmerClellr];
        creatLabels();
    }

    private void creatLabels(){
        for (int j = 0, k = 7; j < labels.length; j++ , k+= 52) {
            for (int i = 0, l = 7; i < labels[j].length; i++ , l += 52) {
                labels[i][j] = new JLabel();
                WindowPanel.panel.add(labels[i][j]/*,BorderLayout.CENTER*/);
                labels[i][j].setBounds(k , l, Config.BOARD,Config.BOARD);
                labels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                labels[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
                labels[i][j].setFont(new Font("Times New Roman", Font.BOLD, 22));
                labels[i][j].setOpaque(true);
                labels[i][j].setBackground(new Color(249,222,255));
                labels[i][j].setVisible(true);
            }
        }
        WindowPanel.panel.updateUI();
    }
}
