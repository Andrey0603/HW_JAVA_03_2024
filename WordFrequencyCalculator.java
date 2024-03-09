import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCalculator {
    private File file;

    public WordFrequencyCalculator(File file) {
        this.file = file;
    }

    public void calculateWordFrequency() {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.replaceAll("[^\\p{L}\\p{Z}]", "").toLowerCase();
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        printSortedWordFrequency(wordFrequency);
    }

    private void printSortedWordFrequency(Map<String, Integer> wordFrequency) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordFrequency.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("Самые популярные овощи и фрукты на пикнике с учетом частоты повторений:");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}