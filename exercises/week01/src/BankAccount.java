/**
 * Created by samaj on 12/01/17.
 */
public class BankAccount {
    private float balance;

    public void deposit(float amount) {
        this.balance += amount;
    }

    public float showBalance() {
        return this.balance;
    }

    BankAccount() {
        balance = 100;
    }
}
