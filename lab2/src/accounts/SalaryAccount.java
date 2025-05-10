package accounts;

public class SalaryAccount extends Account {
    public SalaryAccount() {
        super();
    }

    public void doAutoPayment() {
     //BOOM!
    }

    @Override
    public String toString() {
        return "\nSalaryAccount{" +
                "active=" + active +
                ", balance=" + balance +
                '}';
    }
}
