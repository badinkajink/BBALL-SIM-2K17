/**
 * Created by WilliamUSER on 5/24/2017.
 */

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

/**
 * creates window with two text areas
 */
public class MyGUI2 implements ActionListener {
    JFrame frame;
    MyDrawPanel drawPanel;
    JPanel panelLogo, panelLeft, panelRight;
    JTextArea textAreaLeft, textAreaRight;
    JButton buttonLeft, buttonRight, buttonClearLeft, buttonClearRight;
    JLabel labelLeft, labelRight, labelLogo;
    PrintStream printStreamLeft, printStreamRight;
    PrintStream standardOut, standardErr;

    /**
     * prints to left text area
     * @param strVal
     */
    public void printLogLeft(String strVal) {
        //printStreamLeft.println(strVal + (new Date()));
        printStreamLeft.println(strVal);
    }

    /**
     * prints to right text area
     * @param strVal
     */
    public void printLogRight(String strVal) {
        //printStreamRight.println(strVal + (new Date()));
        printStreamRight.println(strVal);
    }

    /**
     * clears left text area
     */
    public void clearTextAreaLeft() {
        try {
            textAreaLeft.getDocument().remove(0,textAreaLeft.getDocument().getLength());
            //standardOut.println("Text area cleared");
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * clears right text area
     */
    public void clearTextAreaRight() {
        try {
            textAreaRight.getDocument().remove(0,textAreaRight.getDocument().getLength());
            //standardOut.println("Text area cleared");
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * creates two text panels with names and listeners
     * creates room for logo
     * @param labelStr1
     * @param labelStr2
     */
    public void create (String labelStr1, String labelStr2){
        frame = new JFrame();
        buttonLeft    = new JButton("Left");
        buttonRight    = new JButton("Right");
        buttonClearLeft     = new JButton ("Clear");
        buttonClearRight     = new JButton ("Clear");

        buttonLeft.addActionListener(this);
        buttonRight.addActionListener(this);
        buttonClearLeft.addActionListener(this);
        buttonClearRight.addActionListener(this);

        textAreaLeft = new JTextArea(100,60);
        textAreaLeft.setLineWrap(true);
        textAreaRight = new JTextArea(100,60);
        textAreaRight.setLineWrap(true);

        labelLeft = new JLabel(labelStr1);
        labelRight = new JLabel(labelStr2);
        printStreamLeft = new PrintStream(new CustomOutputStream(textAreaLeft));
        printStreamRight = new PrintStream(new CustomOutputStream(textAreaRight));

        // keeps reference of standard output stream
        standardOut = System.out;
        standardErr = System.err;

        // re-assigns standard output stream and error output stream
        //System.setOut(printStreamLeft);
        //System.setErr(printStreamLeft);


        JScrollPane scrollerLeft = new JScrollPane(textAreaLeft);
        scrollerLeft.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerLeft.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JScrollPane scrollerRight = new JScrollPane(textAreaRight);
        scrollerRight.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerRight.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft,BoxLayout.Y_AXIS));
        panelLeft.add(labelLeft);
        panelLeft.add(scrollerLeft);

        panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight,BoxLayout.Y_AXIS));
        panelRight.add(labelRight);
        panelRight.add(scrollerRight);


        labelLogo = new JLabel("Basketball Simulator by William and Eric");

        drawPanel = new MyDrawPanel();
        //drawPanel.add(labelLogo);

        drawPanel.setLayout(new BoxLayout(drawPanel,BoxLayout.Y_AXIS));
        drawPanel.add(new JLabel(" "));
        drawPanel.add(new JLabel(" "));
        drawPanel.add(new JLabel(" "));
        drawPanel.add(new JLabel(" "));
        drawPanel.add(new JLabel(" "));
        drawPanel.add(new JLabel(" "));
        drawPanel.add(new JLabel(" "));
        drawPanel.add(new JLabel(" "));

        frame.getContentPane().add(BorderLayout.NORTH, drawPanel);
        frame.getContentPane().add(BorderLayout.WEST, panelLeft);
        frame.getContentPane().add(BorderLayout.EAST, panelRight);

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400,825);
        frame.setVisible(true);
    }

    /**
     * listener for clear left/right
     * @param event
     */
    public void actionPerformed (ActionEvent event) {
        if (event.getSource() == buttonClearLeft) {
            clearTextAreaLeft();
            //printLogLeft("team \n");
            //labelLeft.setText("new label \n");
        }
        else if (event.getSource() == buttonClearRight) {
            clearTextAreaRight();
            //printLogRight("team \n");
            //labelRight.setText("new label \n");
        }
    }
}
