package accounts;

public class SalaryAccount implements Account {

    private int balance;
    private boolean active;
    public SalaryAccount() {
        super();
    }

    public void doAutoPayment() {
     //BOOM!
    }

       private void sayAccountBlocked() {
        System.out.println("Извините, счет закрыт");
    }
    @Override
    public String toString() {
        return "\nSalaryAccount{" +
                "active=" + active +
                ", balance=" + balance +
                '}';
    }

    @Override
  public void deposit(int count) {
        if (active) {
            this.balance += count;
        } else {
            sayAccountBlocked();
        }
    }
    @Override
    public void withdraw(int count) {
        if (active && this.balance >= count) {
            this.balance -= count;
        } else {
            sayAccountBlocked();
        }
    }

    @Override
    public int getBalance() {
        return this.balance;
    }
}
