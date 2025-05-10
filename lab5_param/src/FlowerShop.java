
import java.util.*;
import java.util.stream.Collectors;

public class FlowerShop {

    // Группировка по виду
    public static Map<String, List<Flower>> groupByType(List<Flower> flowers) {
        return flowers.stream()
                .collect(Collectors.groupingBy(Flower::getName));
    }

    // Сортировка по цене внутри группы
    public static List<Flower> sortByPrice(List<Flower> flowers) {
        return flowers.stream()
                .sorted(Comparator.comparingDouble(Flower::getPrice))
                .collect(Collectors.toList());
    }

    // Фильтрация по ценовой категории
    public static List<Flower> filterByPriceRange(List<Flower> flowers, double minPrice, double maxPrice) {
        return flowers.stream()
                .filter(f -> f.getPrice() >= minPrice && f.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    // Выбор по имени и цвету (через интерфейс-предикат)
    public static List<Flower> filterByPredicate(List<Flower> flowers, FlowerPredicate predicate) {
        return flowers.stream()
                .filter(predicate::test)
                .collect(Collectors.toList());
    }

    // Фильтрация по имени и цвету (через лямбду)
    public static List<Flower> filterByNameAndColor(List<Flower> flowers, String name, String color) {
        return flowers.stream()
                .filter(f -> f.getName().equalsIgnoreCase(name) && f.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    // Сортировка по дате поступления
    public static List<Flower> sortByArrivalDate(List<Flower> flowers) {
        return flowers.stream()
                .sorted(Comparator.comparing(Flower::getArrivalDate))
                .collect(Collectors.toList());
    }

// Компаратор: сначала по цене, потом по дате поступления
    public static Comparator<Flower> flowerComparator = Comparator
            .comparingDouble(Flower::getPrice)
            .thenComparing(Flower::getArrivalDate);

    // Группировка по названию и сортировка внутри групп
    public static Map<String, List<Flower>> groupAndSortFlowers(List<Flower> flowers) {
        return flowers.stream()
                .collect(Collectors.groupingBy(
                    Flower::getName,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                    .sorted(flowerComparator)
                                    .collect(Collectors.toList())
                    )
                ));
    }
}
