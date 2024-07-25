import javax.swing.*;
import java.awt.*;

public class WindowPanel {

    public static JPanel panel;
    public static JPanel panelUp;
    public static JPanel panelStart;

    public WindowPanel() {
        panel = new JPanel();
        panelUp = new JPanel();
        panelStart = new JPanel();
        addPanels();
        new PanelStar();
    }

    public static void start(){
        visual();
        new MenuPanel();
        new GameField();
        MainWindow.jf.addKeyListener(new GameProgress());
    }

    private static void visual(){
        MainWindow.jf.setSize(Config.heigh_width() + 14,Config.heigh_width() + 59);
        visualPanel(panel,22);
        visualPanel(panelUp,0);
        MainWindow.jf.setLocationRelativeTo(null);
        panelStart.setVisible(false);
        panel.setVisible(true);
        panelUp.setVisible(true);
    }

    private static void creatPanel(JPanel pan, int x, int y, int h, int l, Color col, boolean visebabl){
        pan.setLayout(null);
        MainWindow.jf.add(pan);
        pan.setBounds(x,y,h,l);
        pan.setVisible(visebabl);
        pan.setBackground(col);
    }

    private static void visualPanel(JPanel pan, int x){
        pan.setBounds(0,x,Config.heigh_width(),Config.heigh_width());
    }

    public static void addPanels(){
        creatPanel(panel,0,22,Config.WIDTH,Config.HEIGH, new Color(161,86,0), false);//оснавная панель
        creatPanel(panelUp,0,0,Config.WIDTH, 22, Color.GRAY, false);//дополнительная панель, которая сверху
        creatPanel(panelStart,0,0,Config.WIDTH,Config.HEIGH + 22,Color.pink,true);
    }
}
