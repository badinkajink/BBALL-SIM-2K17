/**
 * Created by WilliamUSER on 5/24/2017.
 */

import javax.swing.*;
import java.awt.*;

/**
 * displays logo
 */
public class MyDrawPanel extends JPanel {

/*    public void paintComponent (Graphics g) {
        g.setColor(Color.white);
        g.fillRect (20,50,100,100);
    }
*/

    /**
     * displays logo
     * @param g
     */
    public void paintComponent (Graphics g){
        Image image = new ImageIcon("logo.png").getImage();
        g.drawImage (image,3,4,this);
    }

}