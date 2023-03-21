import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 * This class implements a calculator.
 * 
 * @author Dhruv Patel
 * @version 12.3.2021
 */
public class Calculator
{
    // class Fields
    private JFrame frame;
    private JTextField tField;
    private String s1 = "";
    private String s2 = "";
    private boolean add = false;
    private boolean subtract = false;
    private boolean multiply = false;
    private boolean divide = false;
    private boolean convertRadian = false;
    private boolean absoluteValue = false;
    private boolean convertDegree = false;
    private boolean modulo = false;
    private boolean squareRoot = false;

    private FileWriter fWriter;
    private PrintWriter pWriter;

    /**
     * Constructor for objects of class Calculator
     */
    public Calculator() throws FileNotFoundException, IOException
    {
        makeFrame();
        fWriter = new FileWriter("outputCalc.txt");
        pWriter = new PrintWriter(new FileOutputStream(new File("outputCalc.txt"), true));
    }

    /**
     * makeFrame - sets up the calculator appearance and the buttons
     * event listeners.
     */
    private void makeFrame()
    {
        frame = new JFrame("Simple Calculator");
        frame.setLayout(new BorderLayout());
        makeMenuBar(frame);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout(5, 5));

        JPanel panel = new JPanel();
        tField = new JTextField();
        tField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(tField,BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        tField.setBackground(new Color(30, 61, 89));
        tField.setForeground(Color.WHITE);
        tField.setFont(new Font("Calibri", Font.PLAIN, 28));

        // makes the different buttons
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton bDot = new JButton(".");
        JButton bs = new JButton("-");
        JButton bm = new JButton("*");
        JButton bAdd = new JButton("+");
        JButton bEqual = new JButton("=");
        JButton bClear = new JButton("C");
        JButton bMultiply = new JButton("*");
        JButton bDivide = new JButton("/");
        JButton convertRadian = new JButton("RAD");
        JButton absoluteValue = new JButton("|x|");
        JButton convertDegree = new JButton("DEG");
        JButton backspace = new JButton("BK");
        JButton tanX = new JButton("tan(x)");
        JButton sinX = new JButton("sin(x)");
        JButton cosX = new JButton("cos(x)");
        JButton negate = new JButton("+/-");
        JButton modulo = new JButton("%");
        JButton squareRoot = new JButton("\u221a");

        JButton[] buttons = new JButton[12];
        buttons[0] = b1;
        buttons[1] = b2;
        buttons[2] = b3;
        buttons[3] = b4;
        buttons[4] = b4;
        buttons[5] = b5;
        buttons[6] = b6;
        buttons[7] = b7;
        buttons[8] = b8;
        buttons[9] = b9;
        buttons[10] = b0;
        buttons[11] = bDot;

        JButton[] buttons1 = new JButton[17];
        buttons1[0] = convertDegree;
        buttons1[1] = bs;
        buttons1[2] = bm;
        buttons1[3] = bAdd;
        buttons1[4] = bEqual;
        buttons1[5] = bClear;
        buttons1[6] = bMultiply;
        buttons1[7] = bDivide;
        buttons1[8] = convertRadian;
        buttons1[9] = absoluteValue;
        buttons1[10] = backspace;
        buttons1[11] = tanX;
        buttons1[12] = sinX;
        buttons1[13] = negate;
        buttons1[14] = cosX;
        buttons1[15] = modulo;
        buttons1[16] = squareRoot;

        // adds background colors

        for (JButton i : buttons) {

            i.setBackground(new Color(30, 61, 89));
            i.setForeground(Color.WHITE);
            i.setFont(new Font("Lucida", Font.BOLD, 15));

            i.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        i.setBackground(new Color(255, 193, 59));
                    }

                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        i.setBackground(new Color(30, 61, 89));
                    }
                });        

        }

        for (JButton i : buttons1) {
            i.setBackground(new Color(30, 132, 127));
            i.setForeground(Color.WHITE);
            i.setFont(new Font("Lucida", Font.BOLD, 15));

            i.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        i.setBackground(new Color(236, 193, 156));
                    }

                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        i.setBackground(new Color(30, 132, 127));
                    }
                });        

        }

        // adds the buttons to the panel and organizes them
        panel.setLayout(new GridLayout(0,5,4,4));
        panel.add(bs);
        panel.add(bMultiply);
        panel.add(bDivide);
        panel.add(bAdd);
        panel.add(squareRoot);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b0);
        panel.add(bDot);
        panel.add(bEqual);
        panel.add(bClear);
        panel.add(convertRadian);
        panel.add(absoluteValue);
        panel.add(convertDegree);
        panel.add(backspace);
        panel.add(tanX);
        panel.add(negate);
        panel.add(sinX);
        panel.add(cosX);
        panel.add(modulo);

        // adds ActionListener to each button
        b1.addActionListener(e -> b1());
        b2.addActionListener(e -> b2());
        b3.addActionListener(e -> b3());
        b4.addActionListener(e -> b4());
        b5.addActionListener(e -> b5());
        b6.addActionListener(e -> b6());
        b7.addActionListener(e -> b7());
        b8.addActionListener(e -> b8());
        b9.addActionListener(e -> b9());
        b0.addActionListener(e -> b0());
        bDivide.addActionListener(e -> bDivide());
        bAdd.addActionListener(e -> bAdd());
        bEqual.addActionListener(e ->
            {
                try
                {
                    bEqual();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            });
        bClear.addActionListener(e -> bClear());
        convertRadian.addActionListener(e -> convertRadian());
        absoluteValue.addActionListener(e -> absoluteValue());
        convertDegree.addActionListener(e -> convertDegree());
        bMultiply.addActionListener(e -> bMultiply());
        bs.addActionListener(e -> bSubtract());
        backspace.addActionListener(e -> backspaceLetter());
        tanX.addActionListener(e -> tanX());
        negate.addActionListener(e -> negate());
        sinX.addActionListener(e -> sinX());
        cosX.addActionListener(e -> tanX());
        modulo.addActionListener(e -> modulo());
        bDot.addActionListener(e -> bDot());
        squareRoot.addActionListener(e -> squareRoot());

        frame.add(panel, BorderLayout.CENTER);

        // building is done - arrange the components and show        
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // create the File manu
        JMenu quitMenu = new JMenu("Quit");
        menubar.add(quitMenu);

        quitMenu.setFont(new Font("Lucida", Font.BOLD, 12));

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(e -> quit());
        quitMenu.add(quitItem);

    }

    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }

    private void b0()
    {
        tField.setText(tField.getText()+"0");
    }

    /**
     * b1() inputs text "1" into the text window
     */
    private void b1()
    {
        tField.setText(tField.getText()+"1");
    }

    private void b2() {
        tField.setText(tField.getText()+"2");
    }

    private void b3()
    {
        tField.setText(tField.getText()+"3");
    }

    private void b4()
    {
        tField.setText(tField.getText()+"4");
    }

    private void b5()
    {
        tField.setText(tField.getText()+"5");
    }

    private void b6()
    {
        tField.setText(tField.getText()+"6");
    }

    private void b7()
    {
        tField.setText(tField.getText()+"7");
    }

    private void b8()
    {
        tField.setText(tField.getText()+"8");
    }

    private void b9()
    {
        tField.setText(tField.getText()+"9");
    }

    /**
     * bAdd() sets the add flag to True
     */
    private void bAdd()
    {
        s1 = tField.getText();
        add = true;
        //System.out.println(s1);
        tField.setText("");
    }

    /**
     * bEqual - reads in the two variables and converts them to ints.
     * Then checks the operation flag and does the math.
     * Once done. writes the output to the text field.
     */
    private void bEqual() throws IOException
    {

        s2 = tField.getText();
        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);

        if (add)
        {           
            tField.setText(""+(num1+num2));
            add = false;
        }

        else if (subtract) {
            tField.setText(""+(num1-num2));
            subtract = false;
        }

        else if (multiply) {
            tField.setText(""+(num1*num2));
            multiply = false;
        }

        else if (divide) {            
            tField.setText(""+(num1/num2));
            divide = false; 
        }

        else if (modulo) {
            tField.setText(""+(num1%num2));
            modulo = false;
        }

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Calculation was sucessfully written to file", "Success!",1);     
        pWriter.flush();
    }    

    private void modulo() {
        s1 = tField.getText();
        modulo = true;
        tField.setText("");
    }

    private void bSubtract()
    {
        s1 = tField.getText();
        subtract = true;
        tField.setText("");
    }

    private void bMultiply() 
    {
        s1 = tField.getText();
        multiply = true;
        tField.setText("");  
    }

    private void bDivide() 
    {
        s1 = tField.getText();
        divide = true;
        tField.setText("");  
    } 

    private void bClear()
    {
        tField.setText("");
        s1 = "";
        s2 = "";
        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "File cleared", "Success!",1);     
        pWriter.flush();
    }

    private void convertRadian() 
    {
        s1 = tField.getText();
        double num3 = Double.parseDouble(s1);
        tField.setText("" + Math.toRadians(num3));

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Calculation was sucessfully written to file", "Success!",1);     
        pWriter.flush();
    }

    private void absoluteValue() 
    {
        s1 = tField.getText();
        double num2 = Double.parseDouble(s1);
        tField.setText("" + Math.abs(num2));

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Calculation was sucessfully written to file", "Success!",1);     
        pWriter.flush();
    }

    private void convertDegree() 
    {
        s1 = tField.getText();
        double num3 = Double.parseDouble(s1);
        tField.setText("" + Math.toDegrees(num3));

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Calculation was sucessfully written to file", "Success!",1);     
        pWriter.flush();
    }

    private void backspaceLetter()
    {
        String line1 = "";
        String line = tField.getText();
        int lengthLine = line.length();

        if (lengthLine>=1) {
            tField.setText(line.substring(0,lengthLine-1));
        }

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Deletion was sucessfully written to file", "Success!",1);     
        pWriter.flush();
    }

    private void tanX() {
        s1 = tField.getText();
        double num3 = Double.parseDouble(s1);
        tField.setText("" + Math.tan(num3));

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Calculation was sucessfully written to file", "Success!",1);     
        pWriter.flush();
    }

    private void sinX() {
        s1 = tField.getText();
        double num3 = Double.parseDouble(s1);
        tField.setText("" + Math.sin(num3));  

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Calculation was sucessfully written to file", "Success!",1);     
        pWriter.flush();
    }

    private void cosX() {
        s1 = tField.getText();
        double num3 = Double.parseDouble(s1);
        tField.setText("" + Math.cos(num3));  

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Calculation was sucessfully written to file", "Success!",1);     
        pWriter.flush(); 
    }

    private void negate() {
        s1 = tField.getText();
        double num3 = Double.parseDouble(s1);

        if (num3 < 0) {
            tField.setText("" + Math.abs(num3));
        }

        else {
            tField.setText("" + (num3-(num3*2))); 
        }

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Calculation was sucessfully written to file", "Success!",1);     
        pWriter.flush();
    }
    
    private void bDot() {
        s1 = tField.getText();
        tField.setText(s1.concat("."));
    }
    
    private void squareRoot() {
        s1 = tField.getText();
        double num3 = Double.parseDouble(s1);
        tField.setText("" + Math.sqrt(num3));  

        pWriter.append(tField.getText()+"\n");
        JOptionPane.showMessageDialog(null, "Calculation was sucessfully written to file", "Success!",1);     
        pWriter.flush();
    }
}

