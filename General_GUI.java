import javax.swing.*;
import java.awt.*;
/**
 * This class builds a gui page.
 * 
 * @author (Dr. P. Patankar) 
 * @version (a version number or a date)
 */
public class General_GUI
{
   private static JButton b1;
   private static JLabel l1;
   private static JPanel p1;
   public static void main(String [] args)
   {
       JFrame frame = new JFrame("My Frame");
       frame.setSize(new Dimension(500,500));
       frame.setLocationRelativeTo(null);
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       p1 = new JPanel();
       p1.createToolTip();
       p1.setBackground(Color.yellow);
       b1 = new JButton("Click Me");
       l1 = new JLabel("My Label");
       p1.add(b1);
       p1.add(l1);
       frame.add(p1);
       frame.setVisible(true);
    }  
}
