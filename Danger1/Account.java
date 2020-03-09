import javax.swing.JLabel;

/**
 * A simple bank account.  NSFCA (not safe for concurrent access).
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
    public int getBalance() {
        return balance;
    }

    /**
       Set the balance to a new value and update the label.

       @param newBalance the new balance
    */
    public void setBalance(int newBalance) {
        balance = newBalance;
        display.setText("" + newBalance);
    }
}
