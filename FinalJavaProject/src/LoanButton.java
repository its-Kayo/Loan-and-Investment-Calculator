import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanButton extends JButton implements ActionListener {
    LoanButton(){
        // Use the superclass constructor to set the button text
        super("Loan");
        setPreferredSize(new Dimension(200, 100));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Use a JOptionPane to show input dialogs to the user
        String loanType = null;
        while (loanType == null) {
            loanType = JOptionPane.showInputDialog("Enter type of loan (loan/mortgage):");
            //Make input lower case to restrict errors reading
            String LowerCase_loanType = loanType.toLowerCase();
            if (!LowerCase_loanType.equals("loan") && !LowerCase_loanType.equals("mortgage")) {
                JOptionPane.showMessageDialog(null,"Enter type of loan (loan/mortgage):");
                loanType = null;
            }
        }

        String LowerCase_loanType = loanType.toLowerCase();
        String loanAmountString = JOptionPane.showInputDialog(null, "Enter the amount you wish to borrow:");
        //Turn input from JOptionPane into variable
        double loanAmount = Double.parseDouble(loanAmountString);

        String loanPeriodString = JOptionPane.showInputDialog(null, "Enter the amount of time to pay it off (in years):");
        //Turn input from JOptionPane into variable
        int loanPeriod = Integer.parseInt(loanPeriodString);


        double interestRate = 0;
        if (LowerCase_loanType.equals("loan")) {
            if (loanAmount < 100000) {
                interestRate = 0.03;
            } else if (loanAmount < 450000) {
                interestRate = 0.04;
            } else {
                interestRate = 0.05;
            }
        } else if (LowerCase_loanType.equals("mortgage")) {
            if (loanPeriod >= 1 && loanPeriod <= 10) {
                interestRate = 0.035;
            } else if (loanPeriod <= 15) {
                interestRate = 0.045;
            } else if (loanPeriod <= 20) {
                interestRate = 0.05;
            } else if (loanPeriod <= 25) {
                interestRate = 0.055;
            } else {
                interestRate = 0.06;
            }
        }

        double totalInterest = loanAmount * interestRate * loanPeriod;
        double totalAmount = totalInterest + loanAmount;
        double monthlyPay = totalAmount / (loanPeriod * 12);
        double interestPercent = interestRate * 100;

        // Use a JOptionPane to show message dialogs with the output to the user
        if (LowerCase_loanType.equals("loan")) {
            JOptionPane.showMessageDialog(null,
                    "Loan Period: " + loanPeriod + " years\n" +
                            String.format("Amount borrowed: $%.2f", loanAmount) + "\n" +
                            "Interest rate: " + interestPercent + "%\n" +
                            String.format("Total interest accumulated: $%.2f", totalInterest) + "\n" +
                            String.format("Total amount owed at the end of the loan period: $%.2f", totalAmount)
            );
        } else if (LowerCase_loanType.equals("mortgage")) {
            JOptionPane.showMessageDialog(null,
                    "Mortgage Period: " + loanPeriod + " years\n" +
                            String.format("Amount borrowed: $%.2f", loanAmount) + "\n" +
                            "Interest rate: " + interestPercent + "%\n" +
                            String.format("Total interest accumulated: $%.2f", totalInterest) + "\n" +
                            String.format("Total amount owed at the end of the mortgage period: $%.2f", totalAmount) + "\n" +
                            String.format("Monthly mortgage payment should be:$%.2f", monthlyPay));
        }
    }

}

