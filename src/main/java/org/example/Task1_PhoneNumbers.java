package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task1_PhoneNumbers {

    public void testPhoneNumbers(File file) {
        StringBuilder strB = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            int charCode;
            String tempPhone;
            while ((charCode = reader.read()) != -1) {
                if (((char) charCode) == '\n') {
                    tempPhone = strB.toString().strip();
                    if (isValidPhoneNumber(tempPhone)) {
                        System.out.println(tempPhone);
                    }
                    strB.setLength(0);
                } else {
                    strB.append((char) charCode);
                }
            }
            if (strB.length() != 0) {
                tempPhone = strB.toString().strip();
                if (isValidPhoneNumber(tempPhone)) {
                    System.out.println(tempPhone);
                }
            }
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    private boolean isValidPhoneNumber(String phone) {
        String patternOne = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";
        String patternTwo = "^\\d{3}-\\d{3}-\\d{4}$";
        return phone.matches(patternOne) || phone.matches(patternTwo);
    }
}
