package com.animal.adoption.controller;

import com.animal.adoption.domain.Adoption;
import com.animal.adoption.domain.User;
import com.animal.adoption.service.AdoptionService;
import com.animal.adoption.service.AnimalService;
import com.animal.adoption.service.UserService;
import com.animal.adoption.utils.RestResult;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoption")
public class AdoptionController {
    @Autowired
    private AdoptionService adoptionService;
    @Autowired
    private AnimalService animalService;

    @PostMapping("/save")
    public RestResult save(@RequestBody Adoption adoption) {
        animalService.updateAdoptedTrue(adoption.getAnimalId());
        adoptionService.save(adoption);
        return RestResult.success();
    }

}
