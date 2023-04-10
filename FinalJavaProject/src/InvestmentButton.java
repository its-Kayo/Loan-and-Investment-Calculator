import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InvestmentButton extends JButton implements ActionListener {
    public InvestmentButton() {
        // Use the superclass constructor to set the button text
        super("Investment");
        setPreferredSize(new Dimension(200, 100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            //Text fields for user input
            JTextField investmentField = new JTextField(50);
            JTextField rateField = new JTextField(50);
            JTextField yearField = new JTextField(50);

            //Add text fields to panel
            JPanel inputPanel = new JPanel(new GridLayout(3, 2));
            inputPanel.add(new JLabel("Investment Amount:"));
            inputPanel.add(investmentField);
            inputPanel.add(new JLabel("Annual Interest Rate:"));
            inputPanel.add(rateField);
            inputPanel.add(new JLabel("Number of Years Invested:"));
            inputPanel.add(yearField);

            //Show input dialog
            int result = JOptionPane.showConfirmDialog(null, inputPanel, "Investment Calculator", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                int year = Integer.parseInt(yearField.getText());
                double investment = Double.parseDouble(investmentField.getText());
                double rate = Double.parseDouble(rateField.getText()) / 100;
                System.out.println("Years    Future Value");

                // Create StringBuilder object to store output
                StringBuilder output = new StringBuilder();
                output.append("Years    Future Value\n");

                //for loop to calculate and append the future value for each year to the StringBuilder object.
                for (int i = 1; i <= year; i++) {
                    int formatter = 19;
                    if (i >= 10) formatter = 18;
                    output.append(String.format("%d%" + formatter + ".2f\n", i, futureInvestmentValue(investment, rate / 12, i)));
                }
                // Show output in message dialog
                JOptionPane.showMessageDialog(null, output.toString(), "Investment Calculator Results", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }
}
