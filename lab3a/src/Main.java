import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> wordsCount = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        for (char symbol : text.toCharArray()) {
            if (Character.isLetter(symbol)) {
                wordsCount.put(Character.toLowerCase(symbol),
                        wordsCount.getOrDefault(Character.toLowerCase(symbol), 0) + 1);
            }
        }
        for (char symbol : wordsCount.keySet()) {
            System.out.println("Буква " + symbol + " встечается " + wordsCount.get(symbol) + " раз(а)");
        }
    }
}
