package com.exercise.FizzBuzzApp.service;

import com.exercise.FizzBuzzApp.model.FizzBuzzModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService{
    @Override
    public FizzBuzzModel getFizzBuzzByNumber(String num) {
        if(num.isBlank()){
            List<String> output = new ArrayList<>();
            output.add("Invalid Item");
            return new FizzBuzzModel("<empty>",output);
        }else{
            try {
                int i = Integer.parseInt(num);
                List<String> output = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                if (i % 3 == 0) {
                    sb.append("Fizz");
                }
                if (i % 5 == 0) {
                    sb.append("Buzz");
                }
                String divisionResult = sb.toString();
                if(divisionResult.isEmpty()){
                    output.add("Divided "+ num +" by 3");
                    output.add("Divided "+ num +" by 5");
                }else{
                    output.add(divisionResult);
                }
                return new FizzBuzzModel(num,output);
            }catch (NumberFormatException e){
                List<String> output = new ArrayList<>();
                output.add("Invalid Item");
                return new FizzBuzzModel(num,output);
            }
        }
    }
}
