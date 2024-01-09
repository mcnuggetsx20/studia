/*import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
public class InputDocumentFilter extends DocumentFilter {
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
}*/
