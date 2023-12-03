package homeworks.fileAnalyzer;

import java.io.IOException;

public class FileAnalyzerMain {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Java\\JavaCore\\src\\homeworks\\fileAnalyzer\\text.txt";
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        System.out.println(fileAnalyzer.wordMap(path));
        System.out.println(fileAnalyzer.totalWordCount(path));
        System.out.println(fileAnalyzer.uniqueWordCount(path));
        System.out.println(fileAnalyzer.topFrequentWords(path, 3));
        System.out.println(fileAnalyzer.countWordOccurrences(path, "dolore"));
    }
}
