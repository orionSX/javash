package accounts;

public interface Account {

    void deposit(int count);

    void withdraw(int count);

    int getBalance();

    String toString();

}
