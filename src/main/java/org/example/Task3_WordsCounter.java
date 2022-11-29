package org.example;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task3_WordsCounter {

    public Map<String, Integer> readWordsFromFile(File file) {
        Map<String, Integer> words = new HashMap<>();
        try (FileReader reader = new FileReader(file)) {
            int charCode;
            String tempWord;
            StringBuilder strB = new StringBuilder();
            while ((charCode = reader.read()) != -1) {
                if ((char) charCode == '\n' || (char) charCode == ' ') {
                    tempWord = strB.toString().strip();
                    Integer count = words.get(tempWord);
                    if (count == null) {
                        words.put(tempWord, 1);
                    } else {
                        count++;
                        words.put(tempWord, count);
                    }
                    strB.setLength(0);
                } else {
                    strB.append((char) charCode);
                }
            }
            if (strB.length() != 0) {
                tempWord = strB.toString().strip();
                Integer count = words.get(tempWord);
                if (count == null) {
                    words.put(tempWord, 1);
                } else {
                    count++;
                    words.put(tempWord, count);
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return words;
    }

    public Map<String, Integer> sortMapByValue(Map<String, Integer> words) {
        //Temp method for this stage (without Comparator and stream)

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        int capacity = words.size();

        for (int i = 0; i < capacity; i++) {
            int max = 0;
            String maxKey = null;
            for (Map.Entry<String, Integer> entry : words.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            sortedMap.put(maxKey, max);
            words.remove(maxKey);
        }
        return sortedMap;
    }
}