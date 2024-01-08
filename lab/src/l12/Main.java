//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Main{
    static int textRows = 50, textColumns = 16;
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JButton buttonF1 = new JButton("funkcja1");
        JButton buttonF2 = new JButton("funkcja2");
        JButton buttonF3 = new JButton("funkcja3");

        JTextArea area = new JTextArea(textRows, textColumns);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(area);

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.X_AXIS));
        innerPanel.add(Box.createHorizontalGlue());
        innerPanel.add(buttonF1);
        innerPanel.add(Box.createHorizontalGlue());
        innerPanel.add(buttonF2);
        innerPanel.add(Box.createHorizontalGlue());
        innerPanel.add(buttonF3);
        innerPanel.add(Box.createHorizontalGlue());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(innerPanel);
        panel.add(scroll);

        frame.add(panel);
        frame.setVisible(true);

        return;
    }
}


