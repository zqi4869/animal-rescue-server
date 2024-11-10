package com.animal.adoption.controller;

import com.animal.adoption.service.AnimalService;
import com.animal.adoption.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/unAdopt/list")
    public RestResult findUnAdoptAnimals() {
        return RestResult.success(animalService.findUnAdoptAnimals());
    }

    @GetMapping("/all")
    public RestResult findAll() {
        return RestResult.success(animalService.findAll());
    }
}
