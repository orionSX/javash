import java.util.concurrent.Semaphore;
import java.util.ArrayList;

public class BarberShopSimulation {
    static final int WORKDAY_MINUTES = 24 * 60;
    static final int HAIRCUT_TIME_MINUTES = 60;
    static final int CLIENT_INTERVAL_MINUTES = 40;
    static final int PRICE = 600;

    static final Semaphore barbers = new Semaphore(4);

    static int totalClients = 0;
    static int rejectedClients = 0;
    static int queueFormedAtMinute = -1;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> clientThreads = new ArrayList<>();

        for (int currentMinute = 0; currentMinute < WORKDAY_MINUTES; currentMinute += CLIENT_INTERVAL_MINUTES) {
            int arrivalTime = currentMinute;
            Thread client = new Thread(() -> serveClient(arrivalTime));
            client.start();
            clientThreads.add(client);
            Thread.sleep(CLIENT_INTERVAL_MINUTES); 
        }

        for (Thread t : clientThreads) {
            t.join();
        }

        System.out.println("\n📊 Отчёт:");
        System.out.println("Обслужено клиентов: " + totalClients);
        System.out.println("Отказано (очередь): " + rejectedClients);
        System.out.println("Выручка за сутки: " + (totalClients * PRICE) + " руб.");

        if (queueFormedAtMinute >= 0)
            System.out.println("Очередь начала формироваться через " + queueFormedAtMinute + " минут");
        else
            System.out.println("Очереди не было");
    }

    public static void serveClient(int minute) {
        boolean entered = barbers.tryAcquire();

        if (entered) {
            synchronized (BarberShopSimulation.class) {
                totalClients++;
            }
            System.out.println("[" + minute + " мин] Клиент обслуживается");

            try {
                Thread.sleep(HAIRCUT_TIME_MINUTES);
            } catch (InterruptedException ignored) {}

            barbers.release();
        } else {
            synchronized (BarberShopSimulation.class) {
                rejectedClients++;
                if (queueFormedAtMinute == -1)
                    queueFormedAtMinute = minute;
            }
            System.out.println("[" + minute + " мин] Все мастера заняты. Клиент ушёл.");
        }
    }
}
