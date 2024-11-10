package com.animal.adoption.controller;

import com.animal.adoption.domain.Animal;
import com.animal.adoption.domain.User;
import com.animal.adoption.service.AnimalService;
import com.animal.adoption.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public RestResult save(@RequestBody Animal animal) {
        return RestResult.success(animalService.save(animal));
    }

    @PostMapping("/delete/{id}")
    public RestResult delete(@PathVariable("id") String id) {
        animalService.deleteById(id);
        return RestResult.success();
    }
}
