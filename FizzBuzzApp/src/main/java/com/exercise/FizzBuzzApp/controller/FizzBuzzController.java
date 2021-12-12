package com.exercise.FizzBuzzApp.controller;

import com.exercise.FizzBuzzApp.model.FizzBuzzModel;
import com.exercise.FizzBuzzApp.service.FizzBuzzService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FizzBuzzController {

    private FizzBuzzService fizzBuzzService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @RequestMapping(value = "/fizzBuzz", method = RequestMethod.POST)
    public List<FizzBuzzModel> evaluateFizzBuzz(@RequestBody List<String> numbers){
        List<FizzBuzzModel> result = new ArrayList<>();
        for(String num : numbers) {
            result.add(fizzBuzzService.getFizzBuzzByNumber(num));
        };
        return result;
    }

}
