package com.exercise.FizzBuzzApp.model;

import java.util.List;

public class FizzBuzzModel {
    private String input;
    private List<String> result;

    public FizzBuzzModel(String input, List<String> result) {
        this.input = input;
        this.result = result;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
