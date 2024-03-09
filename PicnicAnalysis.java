import java.io.File;

public class PicnicAnalysis {
    private File file;

    public PicnicAnalysis(File file) {
        this.file = file;
    }

    public void analyzePicnic() {
        int wordCount = WordCounter.countWords(file);
        System.out.println("Количество слов в файле: " + wordCount);

        String longestWord = WordCounter.findLongestWord(file);
        System.out.println("Самое длинное слово в файле: " + longestWord);

        WordFrequencyCalculator wordFrequencyCalculator = new WordFrequencyCalculator(file);
        wordFrequencyCalculator.calculateWordFrequency();
    }
}