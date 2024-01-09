import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.AbstractDocument.DefaultDocumentEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.event.DocumentFilter;

public class A {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TextPane with Styled Input Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextPane textPane = new JTextPane();

        // Pobranie StyledDocument
        StyledDocument styledDocument = textPane.getStyledDocument();

        // Ustawienie stylu dla tekstu wprowadzanego z klawiatury
        SimpleAttributeSet inputStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(inputStyle, Color.BLUE);

        // Ustawienie filtru dokumentu
        ((AbstractDocument) styledDocument).setDocumentFilter(new InputDocumentFilter(styledDocument, inputStyle));

        JScrollPane scrollPane = new JScrollPane(textPane);

        frame.getContentPane().add(scrollPane);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Filtr dokumentu dla tekstu wprowadzanego z klawiatury
    static class InputDocumentFilter extends DocumentFilter {
        private StyledDocument styledDocument;
        private AttributeSet inputStyle;

        public InputDocumentFilter(StyledDocument styledDocument, AttributeSet inputStyle) {
            this.styledDocument = styledDocument;
            this.inputStyle = inputStyle;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException {
            // Dodanie stylu do wprowadzanego tekstu
            styledDocument.insertString(offset, text, inputStyle);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            // Zastąpienie tekstu i dodanie stylu
            styledDocument.replace(offset, length, text, inputStyle);
        }
    }
}
