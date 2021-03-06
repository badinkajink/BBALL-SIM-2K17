/**
 * Created by WilliamUSER on 5/24/2017.
 */

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This class extends from OutputStream to redirect output to a JTextArrea
 * http://www.codejava.net/java-se/swing/redirect-standard-output-streams-to-jtextarea
 * GUI
 * @author codejava.net/java-se/swing/redirect-standard-output-streams-to-jtextarea
 */
public class CustomOutputStream extends OutputStream {

    private JTextArea textArea;

    /**
     * creates text area (text panel in a window)
     * @param textArea outputs console to text area
     */
    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    /**
     * takes input and appends to textArea
     * @param b text method
     * @throws IOException input exception
     */
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}