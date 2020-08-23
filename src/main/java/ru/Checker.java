package ru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Checker {
    public static String findSubstring(String a1, String a2) {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(a2.split(" ")));

        ArrayList<String> subwords = new ArrayList<String>(Arrays.asList(a1.split(" ")));

        ArrayList<String> result = new ArrayList<String>();

        for (String subword : subwords) {
            for (int j = 0; j < words.size(); j++) {
                if (words.get(j).contains(subword)) {
                    result.add(subword);
                    break;
                }
            }
        }
        Collections.sort(result);
        StringBuilder resultString = new StringBuilder();
        for (String i : result) {
            resultString.append(i).append(" ");
        }
        return resultString.toString();
    }

    public static String expanded(int digit) throws Exception {
        if (digit <= 0) {
            throw new Exception("All numbers should be greater than 0.");
        }
        char[] digitToString = String.valueOf(digit).toCharArray();
        int category = digitToString.length - 1;
        StringBuilder result = new StringBuilder(digit + "=");
        for (int i = 0; i < digitToString.length; i++) {
            int numeral = Character.getNumericValue(digitToString[i]);
            if (numeral > 0) {
                int temp = (int) (numeral * Math.pow(10, category));
                result.append(temp);
                if (category > 0) {
                    result.append("+");
                }
            }
            category--;

        }
        return result.toString();
    }
}
