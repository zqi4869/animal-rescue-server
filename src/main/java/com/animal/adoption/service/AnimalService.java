package com.animal.adoption.service;

import com.animal.adoption.domain.Animal;
import com.animal.adoption.domain.Article;
import com.animal.adoption.repository.AnimalRepository;
import com.animal.adoption.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

	@Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findUnAdoptAnimals() {
        return animalRepository.findAllByAdopted(false);
    }

}
