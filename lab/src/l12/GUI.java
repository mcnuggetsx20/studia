import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import javax.swing.text.*;

public class GUI{
    static Dimension mainSize = new Dimension(300, 500),
                     buttonSize = new Dimension(45, 25),
                     textFieldSize = new Dimension(60, 20);

    static int textRows = 50, 
               textColumns = 16,
               verticalSpacing = 10,
               FONT_SIZE = 12;

    static String MAIN_TITLE = "JAVA_LAB",
                  CURRENT_FONT = "Arial";

    static JFrame frame = new JFrame();
    static JTextField currentSelectedText = new JTextField("");
    static JTextPane area = new JTextPane();
    static JPanel innerPanel = new JPanel();
    static JPanel mainPanel = new JPanel();
    static JScrollPane scroll = new JScrollPane(area);

    static JButton buttonF1 = new JButton("Font");
    static JButton buttonF2 = new JButton("F2");
    static JButton buttonF3 = new JButton("F3");

    static Utils utils = new Utils();

    public static void showFontSelection(){
        String[] availableFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        JComboBox fontBox = new JComboBox<>(availableFonts);
        JDialog fontDialog = new JDialog(frame, "Choose your font", true);

        JPanel fontPanel = new JPanel();
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("CANCEL");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev){
                CURRENT_FONT = (String) fontBox.getSelectedItem();
                area.setFont(new Font(CURRENT_FONT, Font.PLAIN, FONT_SIZE));
                System.out.printf("Selected Font: %s%n", CURRENT_FONT);
                fontDialog.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev){
                System.out.println("Font selection canceled");
                fontDialog.dispose();
            }
        });

        fontBox.setPreferredSize(new Dimension(100, 20));

        fontPanel.add(fontBox);
        fontPanel.add(okButton);
        fontPanel.add(cancelButton);

        fontDialog.add(fontPanel);
        fontDialog.setSize(100, 200);
        fontDialog.setLocationRelativeTo(frame);
        fontDialog.setVisible(true);
    }

    public static void frameSetup(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(MAIN_TITLE);
        frame.setSize(mainSize);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static void buttonSetup(){
        Insets buttonMargin = new Insets(5, 5, 5, 5);
        buttonF1.setPreferredSize(buttonSize);
        buttonF2.setPreferredSize(buttonSize);
        buttonF3.setPreferredSize(buttonSize);

        buttonF1.setMargin(buttonMargin);
        buttonF2.setMargin(buttonMargin);
        buttonF3.setMargin(buttonMargin);

        buttonF1.setFont(new Font("IBM Plex Mono", Font.PLAIN, 12));
        buttonF2.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonF3.setFont(new Font("Arial", Font.PLAIN, 12));

        buttonF1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev){
                showFontSelection();
                return;
            }
        });
    }

    public static void areaSetup(){
        area.setDocument(new DefaultStyledDocument());
        StyledDocument areaDocument = area.getStyledDocument();
        SimpleAttributeSet defaultStyle = new SimpleAttributeSet();
        area.setFont(new Font("IBM Plex Mono", Font.PLAIN, 22));

        area.addCaretListener(new CaretListener() { 
            @Override
            public void caretUpdate(CaretEvent ev){
                // zaznaczono tekst
                String selectedText = area.getSelectedText();
                currentSelectedText.setText(utils.sliceText(selectedText, 6));
        StyleConstants.setFontFamily(defaultStyle, "SansSerif");
            }
        });
    }
    
    public static void panelSetup(){
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.X_AXIS));
        innerPanel.add(Box.createHorizontalGlue());
        innerPanel.add(buttonF1);
        innerPanel.add(buttonF2);
        innerPanel.add(buttonF3);
        innerPanel.add(Box.createHorizontalGlue());
        innerPanel.add(currentSelectedText);
        innerPanel.add(Box.createHorizontalGlue());

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createVerticalStrut(verticalSpacing));
        mainPanel.add(innerPanel);
        mainPanel.add(Box.createVerticalStrut(verticalSpacing));
        mainPanel.add(scroll);

    }

    public static void main(String[] args){

        currentSelectedText.setPreferredSize(textFieldSize);
        currentSelectedText.setMaximumSize(textFieldSize);
        currentSelectedText.setMinimumSize(textFieldSize);

        panelSetup();
        areaSetup();
        buttonSetup();
        frameSetup();

        return;
    }
}
