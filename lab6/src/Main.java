public class Main{
    public static void main(String[] args) throws InterruptedException {
        int n = 5;

        NumeratorThread numerator = new NumeratorThread(n);
        DenominatorThread denominator = new DenominatorThread(n);

        numerator.start();
        denominator.start();

        numerator.join();
        denominator.join();

        double result = (double) numerator.getResult() / denominator.getResult();
        System.out.println("\nРезультат деления n!/sum(n+i): " + result + "\n");

        Printer printer = new Printer(n);
        Thread aThread = new Thread(() -> printer.printA());
        Thread bThread = new Thread(() -> printer.printB());

        aThread.start();
        bThread.start();

        aThread.join();
        bThread.join();

        System.out.println("\n=== СИМУЛЯЦИЯ САМОКАТОВ ===");
        ScooterStation station = new ScooterStation();

        Thread userFlow = new Thread(() -> {
            for (int t = 0; t < 24 * 60; t += 10) { 
                station.takeScooter();
                try {
                    Thread.sleep(10); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread refillFlow = new Thread(() -> {
            for (int t = 0; t < 24 * 60; t += 100) { 
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                station.refill(10);
            }
        });

        userFlow.start();
        refillFlow.start();

        userFlow.join();
        refillFlow.join();
    }
}


class NumeratorThread extends Thread {
    private final int n;
    private long result;

    public NumeratorThread(int n) {
        this.n = n;
    }

    public void run() {
        result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Факториал " + n + " = " + result);
    }

    public long getResult() {
        return result;
    }
}

class DenominatorThread extends Thread {
    private final int n;
    private long result;

    public DenominatorThread(int n) {
        this.n = n;
    }

    public void run() {
        result = 0;
        for (int j = 0; j <= n; j++) {
            result += (n + j);
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Сумма (n+i), i=[0.." + n + "] = " + result);
    }

    public long getResult() {
        return result;
    }
}

class Printer {
    private final int times;
    private boolean aTurn = true;

    public Printer(int times) {
        this.times = times;
    }

    public synchronized void printA() {
        for (int i = 0; i < times; i++) {
            while (!aTurn) {
                try {
                    wait();
                } catch (InterruptedException ignored) {}
            }
            System.out.print("A ");
            aTurn = false;
            notify();
        }
    }

    public synchronized void printB() {
        for (int i = 0; i < times; i++) {
            while (aTurn) {
                try {
                    wait();
                } catch (InterruptedException ignored) {}
            }
            System.out.print("B ");
            aTurn = true;
            notify();
        }
    }
}

class ScooterStation {
    private final int capacity = 10;
    private int scooters = 10;

    public synchronized boolean takeScooter() {
        if (scooters > 0) {
            scooters--;
            System.out.println("Пользователь взял самокат. Осталось: " + scooters);
            return true;
        } else {
            System.out.println("Самокатов нет!");
            return false;
        }
    }

    public synchronized void refill(int count) {
        scooters = Math.min(capacity, scooters + count);
        System.out.println("Стоянка пополнена. Самокатов: " + scooters);
    }
}
