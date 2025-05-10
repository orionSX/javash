package accounts;

import java.util.Objects;

public class DepositAccount extends Account {
    private int percent;
    private int depositTime;

    public DepositAccount(int percent, int depositTime) {
        super();
        this.percent = percent;
        this.depositTime = depositTime;
    }

    public int calculatePercentSumByTime() {
        return 1;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getDepositTime() {
        return depositTime;
    }

    public void setDepositTime(int depositTime) {
        this.depositTime = depositTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DepositAccount that = (DepositAccount) o;
        return percent == that.percent && depositTime == that.depositTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), percent, depositTime);
    }

    @Override
    public String toString() {
        return "\nDepositAccount{" +
                "percent=" + percent +
                ", depositTime=" + depositTime +
                ", balance=" + balance +
                ", active=" + active +
                '}';
    }
}
