import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This gui converts Celsius to Fahrenheit.
 * 
 * @author (Dr. P. Patankar) 
 * @version (5/1/2017)
 */
public class Temperature_GUI extends JFrame
{
    private JLabel celsiusLabel;
    private JLabel fahrenheitLabel;
    private JButton convertButton;
    private JTextField tempTextField;
    private JTextField ftextField;
    private JPanel p;
 public Temperature_GUI()
 {
     String str = JOptionPane.showInputDialog(null, "Enter some text : ");
     System.out.println(str);
     JOptionPane.showMessageDialog(null,str + "Thank you!");
     setLayout(new FlowLayout());
     tempTextField = new JTextField(5);
     celsiusLabel = new JLabel("Celsius");
     fahrenheitLabel = new JLabel("Fahrenheit");
     ftextField = new JTextField(5);
     convertButton = new JButton("Convert");
     p = new JPanel();
     p.add(celsiusLabel);
     p.add(tempTextField);
     p.add(fahrenheitLabel);
     p.add(ftextField);
     p.add(convertButton);
     setTitle("Celsius Converter");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     add(p);
     convertButton.addActionListener(
     new ActionListener(){
       public void actionPerformed(ActionEvent evt)
    {
int tempFahr = (int)(Double.parseDouble(tempTextField.getText())*1.8)+32;
        ftextField.setText("" + tempFahr);
    }
    });
     pack();
     setVisible(true);
     
     
 }
}
