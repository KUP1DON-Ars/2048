import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelStar {

    private JLabel lab1;
    private JButton b1 = new JButton();
    private JButton b2 = new JButton();
    private JToggleButton [] toggleButtons;
    private boolean pushButton = false;

    public PanelStar() {
        toggleButtons = new JToggleButton[4];
        creatButtons(b1,"Играть",60, false);//false
        creatButtons(b2,"Выход",150, true);
        creatLaben();
        creatToogleButtom();
        pushBottons();
    }

    private void creatLaben(){
        lab1 = new JLabel("2048");
        WindowPanel.panelStart.add(lab1);
        lab1.setBounds(Config.WIDTH / 3 ,10, 80,40);
        lab1.setFont(new Font("Times New Roman", Font.BOLD, 40));
    }

    private void creatToogleButtom(){
        for (int i = 0, y = 60; i < toggleButtons.length; i++ , y += 44) {
            toggleButtons[i] = new JToggleButton();
            WindowPanel.panelStart.add(toggleButtons[i]);
            pushToggleButtons(toggleButtons[i],i);
            toggleButtons[i].setBounds(10, y, 100, 40);
            toggleButtons[i].setBackground(new Color(255,149,202));
            toggleButtons[i].setFocusable(false);
        }
        nameToggleButtom(toggleButtons[0],"3 X 3");
        nameToggleButtom(toggleButtons[1],"4 X 4");
        nameToggleButtom(toggleButtons[2],"5 X 5");
        nameToggleButtom(toggleButtons[3],"8 X 8");
    }

    private void nameToggleButtom(JToggleButton a, String str){
        a.setFont(new Font("Times New Roman", Font.BOLD, 16));
        a.setText(str);
    }

    private void creatButtons(JButton but, String str, int y, boolean sost){
        but.setText(str);
        WindowPanel.panelStart.add(but);
        but.setBounds(125, y, 80, 80);
        but.setFocusable(false);
        but.setEnabled(sost);
        but.setBackground(new Color(255,149,202));
    }

    private void pushBottons(){
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowPanel.start();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    private void pushToggleButtons(JToggleButton  but, int finalI){
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!pushButton) {
                    pushButton = true;
                    switch (finalI) {
                        case 0:
                            Config.nubmerClellr = 3;
                            break;
                        case 1:
                            Config.nubmerClellr = 4;
                            break;
                        case 2:
                            Config.nubmerClellr = 5;
                            break;
                        case 3:
                            Config.nubmerClellr = 8;
                            Config.number8x8 = 10;
                            break;
                    }
                    b1.setEnabled(true);
                }
                else if (but.isSelected()){
                    but.setSelected(false);
                }
                else {
                    pushButton = false;
                    b1.setEnabled(false);
                }
            }
        });
    }
}
