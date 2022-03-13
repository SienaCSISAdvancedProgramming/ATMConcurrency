import java.util.Random;
import javax.swing.JLabel;

/**
 * Class to represent ATM which withdraws money from a bank
 * Written 11/26/99 by Kim Bruce
 * Changed 3/16/00 by Barbara Lerner
 * Introduced a random pause in the critical section to make interference more
 * probable.
 * Changed 5/7/02 by Jim Teresco to include a longer delay to better see
 * what is happening
 * 
 * @author additional updates, Jim Teresco, Siena College, Spring 2011
 *         Additional updates, CSC 252, The College of Saint Rose, Fall 2013
 * @version Spring 2022
 */

public class ATM extends Thread {

    //private static final int MAX_PAUSE = 10;
    private static final int NUM_TRANSACTIONS = 10;
    private static final int TRANSACTION_INTERVAL = 400;

    //private Random pauseGenerator = new Random();

    private Account account;
    private int change; // Amount of each transaction
    private JLabel info; // Where to display description of transactions
    private int total = 0;

    /**
     * Construct a new ATM object that accesses the given account for
     * transactions in the given amount, with updates on its status
     * displayed in the given label.
     * 
     * @param anAccount the Account to access
     * @param aChange   the transaction amount that will be repeatedly performed
     * @param aInfo     the label where this ATM shows its status
     */
    public ATM(Account anAccount, int aChange, JLabel aInfo) {
        account = anAccount;
        change = aChange;
        info = aInfo;
    }

    /**
     * Run method to repeatedly withdraw "change" from account at bank.
     * This is effectively a deposit when "change" is negative.
     */
    @Override
    public void run() {

        for (int i = 0; i < NUM_TRANSACTIONS; i++) {

            // no contrived delay here
            account.changeBalance(change);

            total = total + change;
            info.setText("" + total);

            // wait until the next transaction should happen
            // we can try this with and without the delay here
            try {
                sleep(TRANSACTION_INTERVAL);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
