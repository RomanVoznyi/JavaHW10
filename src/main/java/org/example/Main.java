package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        testTask1();
        testTask2();
        testTask3();

        System.gc();
    }

    public static void testTask1() {
        System.out.println("----------Task1 - Check allowed phone numbers----------");
        File file = new File(".\\src\\main\\resources\\task1\\phones.txt");
        Task1_PhoneNumbers phoneFilter = new Task1_PhoneNumbers();
        System.out.println("Phone numbers list matching the pattern:");
        phoneFilter.testPhoneNumbers(file);
        System.out.println();
    }

    public static void testTask2() {
        System.out.println("----------Task2 - Convert from text to json----------");
        File fileSource = new File(".\\src\\main\\resources\\task2\\users.txt");
        File fileTarget = new File(".\\src\\main\\resources\\task2\\users.json");
        Task2_UserConverter userConverter = new Task2_UserConverter();

        List<Task2_User> users = userConverter.readUsersFile(fileSource);
        System.out.println("How it was in the form of an array: " + Arrays.toString(users.toArray()));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        System.out.println("How it became in json format: " + json);
        userConverter.writeUsersToFile(json, fileTarget);
        System.out.println();
    }

    public static void testTask3() {
        System.out.println("----------Task3 - Count word's frequency----------");
        File file = new File(".\\src\\main\\resources\\task3\\words.txt");
        Task3_WordsCounter wordsCounter = new Task3_WordsCounter();
        Map<String, Integer> words = wordsCounter.readWordsFromFile(file);
        System.out.println("Read words list: " + words);
        Map<String, Integer> sortedWords = wordsCounter.sortMapByValue(words);
        System.out.println("Sorted words list: ");
        sortedWords.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();
    }
}