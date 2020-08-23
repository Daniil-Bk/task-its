package ru;

import org.springframework.stereotype.Component;

@Component
public class Example1 {
    private final String type = "Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order " +
            "of the strings of a1 which are substrings of strings of a2.";
    private String a1;
    private String a2;
    private String result;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }
}
