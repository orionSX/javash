
import accounts.Account;
import accounts.DebitAccount;
import accounts.DepositAccount;
import accounts.SalaryAccount;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static void addIfUnique(List<Account> accounts, Account account) {
        for (Account acc : accounts) {
            if (acc.equals(account)) {
                return;
            }
        }
        accounts.add(account);
    }
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        DebitAccount debitAccount1 = new DebitAccount(10, 1);
        debitAccount1.deposit(12);
        DebitAccount debitAccount2 = new DebitAccount(12, 12);
        DebitAccount debitAccount3 = new DebitAccount(12, 12);
        DepositAccount depositAccount1 = new DepositAccount(10, 1);
        DepositAccount depositAccount2 = new DepositAccount(10, 1);
        DepositAccount depositAccount3 = new DepositAccount(100, 1);
        DepositAccount depositAccount4 = new DepositAccount(1008, 1);
        DepositAccount depositAccount5 = new DepositAccount(60, 1);
        SalaryAccount salaryAccount1 = new SalaryAccount();
        SalaryAccount salaryAccount2 = new SalaryAccount();

        addIfUnique(accounts, salaryAccount1);
        addIfUnique(accounts, salaryAccount2);
        addIfUnique(accounts, debitAccount1);
        addIfUnique(accounts, debitAccount2);
        addIfUnique(accounts, debitAccount3);
        addIfUnique(accounts, depositAccount1);
        addIfUnique(accounts, depositAccount2);
        addIfUnique(accounts, depositAccount3);
        addIfUnique(accounts, depositAccount4);
        addIfUnique(accounts, depositAccount5);

        System.out.println(accounts);
        System.out.println("Итог. длина списка: "+accounts.size()+";\nДобавлялось 10 эл");

        System.out.println("Сумма на деб. аккаунте: "+ debitAccount1.getBalance());
        debitAccount1.deposit(1);
        System.out.println("Сумма на деб. аккаунте после пополнения: "+debitAccount1.getBalance());
        debitAccount1.withdraw(2);
        System.out.println("Сумма на деб. аккаунте после снятия: "+debitAccount1.getBalance());
    }

}
