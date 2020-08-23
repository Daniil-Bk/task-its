package ru;

import org.springframework.stereotype.Component;

@Component
public class Example2 {
    private final String type = "Write Number in Expanded Form";
    private int number;
    private String result;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
