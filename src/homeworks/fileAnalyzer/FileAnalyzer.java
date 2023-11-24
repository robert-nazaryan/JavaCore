package homeworks.fileAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileAnalyzer {
    public Map<String, Integer> wordMap(String path) throws IOException {
        // Читаем файл, составляем мапу слово-количество и возвращаем ее
        Map<String, Integer> wordMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append(" ");
        }
        String[] words = String.valueOf(content).split(" ");
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        return wordMap;
    }

    public int totalWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем общее количество слов
        BufferedReader br = new BufferedReader(new FileReader(path));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append(" ");
        }
        return String.valueOf(content).split(" ").length;
    }

    public int uniqueWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем количество уникальных слов
        BufferedReader br = new BufferedReader(new FileReader(path));
        Set<String> uniqueWords = new HashSet<>();
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append(" ");
        }
        String[] words = String.valueOf(content).split(" ");
        for (String word : words) {
            uniqueWords.add(word);
        }
        return uniqueWords.size();
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        // Читаем файл, находим топ-N часто встречающихся слов
        Map<String, Integer> wordMap = wordMap(path);
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            set.add(entry.getValue());
        }
        for (Integer num : set) {
            if ((n--) == 0) {
                break;
            }
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        return sortedMap;
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        // Читаем файл, находим количество вхождений слова и возвращаем это число
        Map<String, Integer> wordMap = new HashMap<>(wordMap(path));
        return wordMap.get(word);
    }

}
