package iloveyouboss;

public class Account {
    private String accountName;
    private int balance;

    public Account(String accountName) {
        this.accountName = accountName;
        this.balance = 0;
    }

    public void deposit(int value) { this.balance += value; }

    public boolean hasPositiveBalance() { return this.balance > 0; }

    public int getBalance() { return balance; }

    public void withdraw(int value) throws InsufficientFundsException {
        if (this.balance < value) {
            throw new InsufficientFundsException();
        }
        this.balance -= value;
    }
}
