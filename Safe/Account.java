import javax.swing.JLabel;

/**
 * A simple bank account.  This one has become safe for concurrent
 * access by adding the synchronized keyword to prevent concurrent 
 * access to the shared variable.
 * 
 * @author original unknown
 * Updated for Java Swing, Jim Teresco, The College of Saint Rose, Fall 2013
 * @version Spring 2020
 */

public class Account {

    private int balance;
    private JLabel display;  // label on screen for balance

    /**
       Construct a new account with the given starting balance, which
       will be displayed on the given label.

       @param start initial account balance
       @param aDisplay the label where the balance will be displayed
    */
    public Account(int start, JLabel aDisplay) {
        balance = start;
        display = aDisplay;
        display.setText("" + balance);
    }

    /**
       Get the current balance.

       @return the current balance
    */
    public synchronized int getBalance() {
        return balance;
    }

    /**
       Change the balance by the given amount and update the label.

       @param change the amount by which to change the balance
    */
    public synchronized void changeBalance(int change) {
        balance = balance + change;
        display.setText("" + balance);

	// alternate:
        //int newBalance = balance + change;
        //display.setText("" + newBalance);
        //balance = newBalance;

    }
}
