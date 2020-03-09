import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class that represents a bank with two ATM's making deposits and withdrawals.
 * This program was designed to illustrate problems with concurrency.
 * Written 11/26/99 by Kim Bruce.
 * Changed 3/16/99 by Barbara Lerner to use a different UI showing just current values, not
 * a transaction history.
 * 
 * @author updated by Jim Teresco, Siena College, Spring 2011
 * Further updated for Swing and to remove dependency on Objectdraw
 * by Jim Teresco, The College of Saint Rose, Fall 2013, CSC 252
 * Further updated to remove JApplet, Jim Teresco, Siena College, Spring 2020
 * @version Spring 2020
 */

public class Bank implements Runnable, ActionListener {

    private static final int INITIAL_BALANCE = 1000;        // Initial balance in bank account
    private static final int TRANSACTION_AMOUNT = 100;      // how much to deposit/withdraw per xaction

    private JLabel currentBalanceLabel;
    private JLabel withdrawTotalLabel;
    private JLabel depositTotalLabel;

    // Set up window layout and two ATM threads
    @Override
    public void run() {

	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame frame = new JFrame("Danger1");
	frame.setPreferredSize(new Dimension(500,500));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel panel = new JPanel(new GridLayout(0, 1));
	
        JLabel startBalance = new JLabel("Starting balance:  " + INITIAL_BALANCE, JLabel.CENTER);
        JLabel currentLabel = new JLabel("Current balance:  ", JLabel.RIGHT);
        currentBalanceLabel = new JLabel("" + INITIAL_BALANCE + "     ", JLabel.LEFT);
        JLabel withdrawLabel = new JLabel("Amount withdrawn:  ", JLabel.RIGHT);
        withdrawTotalLabel = new JLabel("         0    ", JLabel.LEFT);
        JLabel depositLabel = new JLabel("Amount deposited:  ", JLabel.RIGHT);
        depositTotalLabel = new JLabel("         0    ", JLabel.LEFT);

	Font bigger = new Font("System", Font.PLAIN, 18);
	startBalance.setFont(bigger);
	currentLabel.setFont(bigger);
	currentBalanceLabel.setFont(bigger);
	withdrawLabel.setFont(bigger);
	withdrawTotalLabel.setFont(bigger);
	depositLabel.setFont(bigger);
	depositTotalLabel.setFont(bigger);

        panel.add(startBalance);

        JPanel balancePanel = new JPanel();
        balancePanel.add(currentLabel);
        balancePanel.add(currentBalanceLabel);
        panel.add(balancePanel);

        JPanel withdrawPanel = new JPanel();
        withdrawPanel.add(withdrawLabel);
        withdrawPanel.add(withdrawTotalLabel);
        panel.add(withdrawPanel);

        JPanel depositPanel = new JPanel();
        depositPanel.add(depositLabel);
        depositPanel.add(depositTotalLabel);
        panel.add(depositPanel);

        JPanel buttonPanel = new JPanel();
        JButton runIt = new JButton("Run demo");
        buttonPanel.add(runIt,"South");
        panel.add(buttonPanel);
        runIt.addActionListener(this);

	frame.add(panel);
	frame.pack();
	frame.setVisible(true);

    }

    /**
       Run the demo each time the button is pressed.
       
       @param evt ActionEvent that triggered this call
    */
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        Account account = new Account(INITIAL_BALANCE, currentBalanceLabel);
        ATM atm1 = new ATM(account, 100, depositTotalLabel);
        ATM atm2 = new ATM(account, -100, withdrawTotalLabel);
	atm1.start();
	atm2.start();
    }

    public static void main(String args[]) {

	javax.swing.SwingUtilities.invokeLater(new Bank());
    }
    
}
