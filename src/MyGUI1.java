/**
 * Created by WilliamUSER on 5/24/2017.
 * @author william
 * creates window with 1 text box
 * not used anymore
 */

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class MyGUI1 implements ActionListener {
    JFrame frame;
    MyDrawPanel drawPanel;
    JPanel panelLogo, panelBB;
    JTextArea textAreaBB;
    JButton buttonClear;
    JLabel labelBB, labelLogo;
    PrintStream printStreamBB;
    PrintStream standardOut, standardErr;

    /**
     * prints to text box
     * @param strVal output
     */
    public void printLog(String strVal) {
        //System.out.println("Time now is " + (new Date()));
        printStreamBB.println(strVal);
    }

    /**
     * clears text box
     */
    public void clearTextArea() {
        try {
            textAreaBB.getDocument().remove(0,textAreaBB.getDocument().getLength());
            //standardOut.println("Text area cleared");
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * creates buttons that aren't really used, just wanted to try it
     * also creates panel for logo
     * @param labelStr text area label
     */
    public void create (String labelStr){
        frame = new JFrame();
        buttonClear     = new JButton ("Clear");

        buttonClear.addActionListener(this);

        textAreaBB = new JTextArea(100,78);
        textAreaBB.setLineWrap(true);

        labelBB = new JLabel(labelStr);
        printStreamBB = new PrintStream(new CustomOutputStream(textAreaBB));

        // keeps reference of standard output stream
        standardOut = System.out;
        standardErr = System.err;

        // re-assigns standard output stream and error output stream
        //System.setOut(printStreamBB);
        //System.setErr(printStreamBB);

        JScrollPane scrollerBB = new JScrollPane(textAreaBB);
        scrollerBB.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerBB.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        panelBB = new JPanel();
        panelBB.setLayout(new BoxLayout(panelBB,BoxLayout.Y_AXIS));
        panelBB.add(labelBB);
        panelBB.add(buttonClear);
        panelBB.add(scrollerBB);

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
        frame.getContentPane().add(BorderLayout.EAST, panelBB);

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,750);
        frame.setVisible(true);
    }

    /**
     * clears text area
     * @param event button pressing to clear text area
     */
    public void actionPerformed (ActionEvent event) {
        if (event.getSource() == buttonClear) {
            clearTextArea();
            //printLog("teams \n");
            //labelBB.setText("new label \n");
        }
    }
}
