
import java.time.LocalDate;

public class Flower {
    private String name;           // Название цветка
    private String color;          // Цвет
    private double price;          // Цена
    private LocalDate arrivalDate; // Дата поступления

    public Flower(String name, String color, double price, LocalDate arrivalDate) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.arrivalDate = arrivalDate;
    }

    // Геттеры
    public String getName() { return name; }
    public String getColor() { return color; }
    public double getPrice() { return price; }
    public LocalDate getArrivalDate() { return arrivalDate; }

    @Override
    public String toString() {
        return name + " (" + color + ") - " + price + "$ [" + arrivalDate + "]";
    }
}
