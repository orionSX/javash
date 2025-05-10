
package accounts;

import java.util.Objects;

public class DebitAccount extends Account {
    private int percent;
    private int timeToCloseDebit;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setTimeToCloseDebit(int timeToCloseDebit) {
        this.timeToCloseDebit = timeToCloseDebit;
    }

    @Override
    public String toString() {
        return "\nDebitAccount{" +
                "active=" + active +
                ", balance=" + balance +
                ", timeToCloseDebit=" + timeToCloseDebit +
                ", percent=" + percent +
                '}';
    }

    public DebitAccount(int percent, int timeToCloseDebit) {
        super();
        this.percent = percent;
        this.timeToCloseDebit = timeToCloseDebit;
    }

    public int getTimeToCloseDebit() {
        return this.timeToCloseDebit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DebitAccount that = (DebitAccount) o;
        return percent == that.percent && timeToCloseDebit == that.timeToCloseDebit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), percent, timeToCloseDebit);
    }
}
