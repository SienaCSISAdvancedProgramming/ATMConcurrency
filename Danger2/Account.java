import javax.swing.JLabel;

/**
 * A simple bank account. Still NSFCA (not safe for concurrent access).
 * 
 * @author original unknown
 *         Updated for Java Swing, Jim Teresco, The College of Saint Rose, Fall
 *         2013
 * @version Spring 2022
 */

public class Account {

    private int balance;
    private JLabel display; // label on screen for balance

    /**
     * Construct a new account with the given starting balance, which
     * will be displayed on the given label.
     * 
     * @param start    initial account balance
     * @param aDisplay the label where the balance will be displayed
     */
    public Account(int start, JLabel aDisplay) {
        balance = start;
        display = aDisplay;
        display.setText("" + balance);
    }

    /**
     * Get the current balance.
     * 
     * @return the current balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Change the balance by the given amount and update the label.
     * 
     * @param change the amount by which to change the balance
     */
    public void changeBalance(int change) {
        balance = balance + change;
        display.setText("" + balance);

        // alternate:
        // int newBalance = balance + change;
        // display.setText("" + newBalance);
        // balance = newBalance;

    }
}
