package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2_UserConverter {

    public List<Task2_User> readUsersFile(File file) {
        List<Task2_User> users = new ArrayList<>();
        try (FileReader reader = new FileReader(file)) {
            int charCode;
            String tempLine;
            boolean isHeaderEnds = false;
            StringBuilder strB = new StringBuilder();

            while ((charCode = reader.read()) != -1) {
                if (!isHeaderEnds) {
                    if ((char) charCode == '\n') {
                        isHeaderEnds = true;
                    }
                    continue;
                }
                if ((char) charCode == '\n') {
                    tempLine = strB.toString().strip();
                    String[] arr = tempLine.split(" ");
                    users.add(new Task2_User(arr[0], Integer.parseInt(arr[1])));
                    strB.setLength(0);
                } else {
                    strB.append((char) charCode);
                }
            }
            if (strB.length() != 0) {
                tempLine = strB.toString().strip();
                String[] arr = tempLine.split(" ");
                users.add(new Task2_User(arr[0], Integer.parseInt(arr[1])));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return users;
    }

    public void writeUsersToFile(String json, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
            writer.flush();
            System.out.println("File '" + file.getName() + "' has been written");
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}