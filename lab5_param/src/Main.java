
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Flower> flowers = List.of(
            new Flower("Роза", "Красный", 10.5, LocalDate.of(2025, 5, 1)),
            new Flower("Роза", "Белый", 12.0, LocalDate.of(2025, 5, 2)),
            new Flower("Лилия", "Белый", 8.0, LocalDate.of(2025, 5, 5)),
            new Flower("Тюльпан", "Желтый", 7.0, LocalDate.of(2025, 4, 30)),
            new Flower("Хризантема", "Фиолетовый", 6.5, LocalDate.of(2025, 5, 3))
        );

        System.out.println("== По группам по виду ==");
        Map<String, List<Flower>> grouped = FlowerShop.groupByType(flowers);
        grouped.forEach((type, flist) -> {
            System.out.println(type + ": " + FlowerShop.sortByPrice(flist));
        });

        System.out.println("\n== В ценовом диапазоне 7-10 ==");
        System.out.println(FlowerShop.filterByPriceRange(flowers, 7, 10));

        System.out.println("\n== Розы красного цвета (через лямбду) ==");
        System.out.println(FlowerShop.filterByNameAndColor(flowers, "Роза", "Красный"));

        System.out.println("\n== Лилии белого цвета (через предикат) ==");
        List<Flower> whiteLilies = FlowerShop.filterByPredicate(flowers, f ->
                f.getName().equalsIgnoreCase("Лилия") && f.getColor().equalsIgnoreCase("Белый"));
        System.out.println(whiteLilies);

        System.out.println("\n== Сортировка по дате поступления ==");
        System.out.println(FlowerShop.sortByArrivalDate(flowers));

        System.out.println("\n==  ==");
Map<String, List<Flower>> groupedSorted = FlowerShop.groupAndSortFlowers(flowers);

        groupedSorted.forEach((name, list) -> {
            System.out.println("Вид: " + name);
            list.forEach(System.out::println);
        });
    }
}
