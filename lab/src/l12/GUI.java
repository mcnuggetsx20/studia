import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;

public class GUI{
    static Dimension mainSize = new Dimension(300, 500),
                     buttonSize = new Dimension(50, 20),
                     textFieldSize = new Dimension(60, 20);

    static int textRows = 50, 
               textColumns = 16,
               verticalSpacing = 10;

    static String mainTitle = "JAVA_LAB";

    public static String sliceText(String n, int max){
        if(n==null){n="...";}
        String res = n.substring(0, Math.min(n.length(), max));
        if(n.length() > max){res += "...";}
        return res;
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(mainTitle);
        frame.setSize(mainSize);

        JTextField currentSelectedText = new JTextField("");
        currentSelectedText.setPreferredSize(textFieldSize);

        currentSelectedText.setMaximumSize(textFieldSize);
        currentSelectedText.setMinimumSize(textFieldSize);

        JButton buttonF1 = new JButton("C");
        JButton buttonF2 = new JButton("F2");
        JButton buttonF3 = new JButton("F3");
        buttonF1.setPreferredSize(buttonSize);
        buttonF2.setPreferredSize(buttonSize);
        buttonF3.setPreferredSize(buttonSize);
        buttonF1.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        buttonF2.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonF3.setFont(new Font("Arial", Font.PLAIN, 12));

        buttonF1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev){
                //currentSelectedText
            }
        });

        JTextArea area = new JTextArea(textRows, textColumns);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        area.addCaretListener(new CaretListener() { 
            @Override
            public void caretUpdate(CaretEvent ev){
                // zaznaczono tekst
                String selectedText = area.getSelectedText();
                currentSelectedText.setText(sliceText(selectedText, 6));
            }
        });

        JScrollPane scroll = new JScrollPane(area);

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.X_AXIS));
        innerPanel.add(Box.createHorizontalGlue());
        innerPanel.add(buttonF1);
        innerPanel.add(buttonF2);
        innerPanel.add(buttonF3);
        innerPanel.add(Box.createHorizontalGlue());
        innerPanel.add(currentSelectedText);
        innerPanel.add(Box.createHorizontalGlue());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(verticalSpacing));
        panel.add(innerPanel);
        panel.add(Box.createVerticalStrut(verticalSpacing));
        panel.add(scroll);

        frame.add(panel);
        frame.setVisible(true);

        return;
    }
}
