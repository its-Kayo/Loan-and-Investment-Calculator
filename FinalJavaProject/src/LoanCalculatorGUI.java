import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;



public class LoanCalculatorGUI {
    public static void main(String[] args) {
        //JFrame = GUI window to add components to
        JFrame frame = new JFrame();// creates frame
        frame.setSize(1350, 800);// sets the x-dimension, and the y-dimension of frame
        frame.setTitle("Personal Loan and Investment Calculator"); // sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit out of application
        frame.setResizable(false);//Restricts frame for being resized

        //Header label
        JLabel label = new JLabel();//create label
        label.setText("Personal Loan and Investment Calculator");// set text of label
        label.setIcon(new ImageIcon("Bank.png"));
        label.setHorizontalTextPosition(JLabel.CENTER);// set text left, right or center of image
        label.setVerticalTextPosition(JLabel.TOP);//set text top, center or bottom of image
        label.setForeground(new Color(0x123456));//set colour of text
        label.setFont(new Font("Times New Roman", Font.BOLD, 25)); //set font of text
        label.setIconTextGap(-8);//set gap of text to image
        label.setBackground(Color.ORANGE);//set background colour
        label.setOpaque(true);//display background colour
        Border border = BorderFactory.createLineBorder(new Color(0x123456), 3);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.TOP); //set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER);//set horizontal position of icon+text within label
        label.setBounds(0, 0, 1350, 250); // set x and y position within frame as well as dimensions
        frame.add(label);

        //Body Label
        JLabel label2 = new JLabel();
        label2.setText("Please choose what you wish to calculate:");
        label2.setBackground(new Color(0x123456));
        label2.setForeground(Color.ORANGE);
        label2.setOpaque(true);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.TOP);
        label2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        label2.setBounds(0, 250, 1350, 1000);
        frame.add(label2);

        //Create buttons
        LoanButton button1 = new LoanButton();
        InvestmentButton button2 = new InvestmentButton();

        //Create panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 150));
        buttonPanel.setOpaque(false);
        buttonPanel.add(button1);
        buttonPanel.add(button2);


        //Add button panel to label2
        label2.setLayout(new BorderLayout());
        label2.add(buttonPanel, BorderLayout.CENTER);


        // JPanel to hold the label and set the border around it
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1350, 250);
        panel.setBorder(BorderFactory.createLineBorder(Color.orange, 3));
        frame.add(panel);
        frame.setVisible(true);

    }
}

