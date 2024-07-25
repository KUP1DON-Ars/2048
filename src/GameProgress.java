import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameProgress extends KeyAdapter {

    private int randomNumberOn_4;
    private final int NUMBER_RANDON_4 = 9;
    private boolean inGame = true;


    public GameProgress() {
        randomNumberOn_4 = 0;
        inputLabenRandom();
        inputLabenRandom();
        colorLaben();
    }

    private int random(){
        return ((int) (Math.random()*Config.nubmerClellr));
    }

    private int inputLabenRandom(){
        int a = random();
        int b = random();
        if (GameField.labels[a][b].getText().equals("") && randomNumberOn_4 != NUMBER_RANDON_4){
            GameField.labels[a][b].setText("2");
            randomNumberOn_4++;
            return 0;
        }
        else if (GameField.labels[a][b].getText().equals("") && randomNumberOn_4 == NUMBER_RANDON_4){
            GameField.labels[a][b].setText("4");
            randomNumberOn_4 = 0;
        }
        else{
            return inputLabenRandom();
        }
        return 0;
    }

    private void moveLeftNumbers(){
        for (int i = 0; i < GameField.labels.length; i++) {
            for (int j = 0; j < GameField.labels[i].length; j++) {
                for (int k = j + 1; k < GameField.labels.length; k++) {
                    if (GameField.labels[i][j].getText().equals("")){
                        break;
                    }
                    else if (!GameField.labels[i][j].getText().equals(GameField.labels[i][k].getText()) &&
                            !GameField.labels[i][k].getText().equals("")){
                        break;
                    }
                    else if (GameField.labels[i][j].getText().equals(GameField.labels[i][k].getText())){
                        GameField.labels[i][j].setText(String.valueOf(Integer.parseInt(GameField.labels[i][j].getText()) +
                                Integer.parseInt(GameField.labels[i][k].getText())));
                        GameField.labels[i][k].setText("");
                        break;
                    }
                }
            }
        }
    }

    private void sortingLeft(){
        for (int i = 0; i < GameField.labels.length; i++) {
            boolean sorting = false;
            String buf;
            while (!sorting){
                sorting = true;
                for (int j = 0; j < GameField.labels.length - 1; j++) {
                    if (GameField.labels[i][j].getText().equals("") && !GameField.labels[i][j + 1].getText().equals("")) {
                        sorting = false;
                        buf = GameField.labels[i][j].getText();
                        GameField.labels[i][j].setText(GameField.labels[i ][j + 1].getText());
                        GameField.labels[i][j + 1].setText(buf);
                    }
                }
            }
        }
    }

    private void moveUpNumbers(){
        for (int i = 0; i < GameField.labels.length; i++) {
            for (int j = 0; j < GameField.labels[i].length; j++) {
                for (int k = j + 1; k < GameField.labels.length; k++) {
                    if (GameField.labels[j][i].getText().equals("")){
                        break;
                    }
                    else if (!GameField.labels[j][i].getText().equals(GameField.labels[k][i].getText()) &&
                            !GameField.labels[k][i].getText().equals("")){
                        break;
                    }
                    else if (GameField.labels[j][i].getText().equals(GameField.labels[k][i].getText())){
                        GameField.labels[j][i].setText(String.valueOf(Integer.parseInt(GameField.labels[j][i].getText()) +
                                Integer.parseInt(GameField.labels[k][i].getText())));
                        GameField.labels[k][i].setText("");
                        break;
                    }
                }
            }
        }
    }

    private void sortingUp(){
        for (int i = 0; i < GameField.labels.length; i++) {
            boolean sorting = false;
            String buf;
            while (!sorting){
                sorting = true;
                for (int j = 0; j < GameField.labels.length - 1; j++) {
                    if (GameField.labels[j][i].getText().equals("") && !GameField.labels[j + 1][i].getText().equals("")) {
                        sorting = false;
                        buf = GameField.labels[j][i].getText();
                        GameField.labels[j][i].setText(GameField.labels[j + 1][i].getText());
                        GameField.labels[j + 1][i].setText(buf);
                    }
                }
            }
        }
    }

    private void moveRightNumbers(){
        for (int i = GameField.labels.length - 1; i >= 0; i--) {
            for (int j = GameField.labels[i].length - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (GameField.labels[i][j].getText().equals("")){
                        break;
                    }
                    else if (!GameField.labels[i][j].getText().equals(GameField.labels[i][k].getText()) &&
                            !GameField.labels[i][k].getText().equals("")){
                        break;
                    }
                    else if (GameField.labels[i][j].getText().equals(GameField.labels[i][k].getText())){
                        GameField.labels[i][j].setText(String.valueOf(Integer.parseInt(GameField.labels[i][j].getText()) +
                                Integer.parseInt(GameField.labels[i][k].getText())));
                        GameField.labels[i][k].setText("");
                        break;
                    }
                }
            }
        }
    }

    private void sortingRight(){
        for (int i = GameField.labels.length - 1; i >= 0; i--) {
            boolean sorting = false;
            String buf;
            while (!sorting){
                sorting = true;
                for (int j = GameField.labels.length - 1; j > 0; j--) {
                    if (GameField.labels[i][j].getText().equals("") && !GameField.labels[i][j - 1].getText().equals("")) {
                        sorting = false;
                        buf = GameField.labels[i][j].getText();
                        GameField.labels[i][j].setText(GameField.labels[i ][j - 1].getText());
                        GameField.labels[i][j - 1].setText(buf);
                    }
                }
            }
        }
    }

    private void moveDownNumbers(){
        for (int i = GameField.labels.length - 1; i >= 0; i--) {
            for (int j = GameField.labels.length - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (GameField.labels[j][i].getText().equals("")){
                        break;
                    }
                    else if (!GameField.labels[j][i].getText().equals(GameField.labels[k][i].getText()) &&
                            !GameField.labels[k][i].getText().equals("")){
                        break;
                    }
                    else if (GameField.labels[j][i].getText().equals(GameField.labels[k][i].getText())){
                        GameField.labels[j][i].setText(String.valueOf(Integer.parseInt(GameField.labels[j][i].getText()) +
                                Integer.parseInt(GameField.labels[k][i].getText())));
                        GameField.labels[k][i].setText("");
                        break;
                    }
                }
            }
        }
    }

    private void sortingDown(){
        for (int i = GameField.labels.length - 1; i >= 0; i--) {
            boolean sorting = false;
            String buf;
            while (!sorting){
                sorting = true;
                for (int j = GameField.labels.length - 1; j > 0; j--) {
                    if (GameField.labels[j][i].getText().equals("") && !GameField.labels[j - 1][i].getText().equals("")) {
                        sorting = false;
                        buf = GameField.labels[j][i].getText();
                        GameField.labels[j][i].setText(GameField.labels[j - 1][i].getText());
                        GameField.labels[j - 1][i].setText(buf);
                    }
                }
            }
        }
    }

    private void colorLaben(){
        for (int i = 0; i < GameField.labels.length; i++) {
            for (int j = 0; j < GameField.labels[i].length; j++) {
                if (!GameField.labels[i][j].getText().equals("")) {
                    switch (Integer.parseInt(GameField.labels[i][j].getText())) {
                        case 2:
                            GameField.labels[i][j].setBackground(new Color(255,237,195));
                            break;
                        case 4:
                            GameField.labels[i][j].setBackground(new Color(255,214,140));
                            break;
                        case 8:
                            GameField.labels[i][j].setBackground(new Color(255,158,109));
                            break;
                        case 16:
                            GameField.labels[i][j].setBackground(new Color(255,116,30));
                            break;
                        case 32:
                            GameField.labels[i][j].setBackground(new Color(215,64,0));
                            break;
                        case 64:
                            GameField.labels[i][j].setBackground(new Color(197,85,0));
                            break;
                        case 128:
                            GameField.labels[i][j].setBackground(new Color(248,255,137));
                            break;
                        case 256:
                            GameField.labels[i][j].setBackground(new Color(254,254,75));
                            break;
                        case 512:
                            GameField.labels[i][j].setBackground(new Color(255,255,0));
                            break;
                        default:
                            GameField.labels[i][j].setBackground(new Color(255, 0, 0));
                            break;
                    }
                }
                else
                    GameField.labels[i][j].setBackground(new Color(249,222,255));
            }
        }
    }

    private void defeat(){
        int z = 0;
        for (int i = 0; i < GameField.labels.length; i++) {
            for (int j = 0; j < GameField.labels[i].length; j++) {
                if (!GameField.labels[i][j].getText().equals("")) {
                    z++;
                }
            }
        }
        if (z == Config.nubmerClellr*Config.nubmerClellr){
            JOptionPane.showMessageDialog(null,"Вы проиграли!!!");
            inGame = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            moveLeftNumbers();
            sortingLeft();
        }
        if(key == KeyEvent.VK_RIGHT){
            moveRightNumbers();
            sortingRight();
        }
        if(key == KeyEvent.VK_UP){
            moveUpNumbers();
            sortingUp();
        }
        if(key == KeyEvent.VK_DOWN){
            moveDownNumbers();
            sortingDown();
        }
        defeat();
        if (inGame){
            inputLabenRandom();
            colorLaben();
        }
    }
}
