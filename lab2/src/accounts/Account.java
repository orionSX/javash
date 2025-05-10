package accounts;

import java.util.Objects;

public abstract class Account {
    protected int balance;
    protected boolean active;

    public void deposit(int count) {
        if (active) {
            this.balance += count;
        } else {
            sayAccountBlocked();
        }
    }

    public void withdraw(int count) {
        if (active && this.balance >= count) {
            this.balance -= count;
        } else {
            sayAccountBlocked();
        }
    }

    public int getBalance() {
        if (active) {
            return this.balance;
        } else {
            sayAccountBlocked();
            return -1;
        }
    }

    public Account() {
        this.balance = 0;
        this.active = true;
    }

    @Override
    public String toString() {
        return "\nAccount{" +
                "balance=" + balance +
                ", active=" + active +
                '}';
    }

    public void closeAccount() {
        this.active = false;
    }

    private void sayAccountBlocked() {
        System.out.println("Извините, счет закрыт");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return balance == account.balance && active == account.active;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, active);
    }
}
