import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
    public static int countWords(File file) {
        int count = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static String findLongestWord(File file) {
        String longestWord = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return longestWord;
    }
}
