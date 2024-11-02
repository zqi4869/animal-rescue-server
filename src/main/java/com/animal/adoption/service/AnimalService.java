package com.animal.adoption.service;

import com.animal.adoption.domain.Animal;
import com.animal.adoption.domain.Article;
import com.animal.adoption.repository.AnimalRepository;
import com.animal.adoption.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

	@Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Animal> findUnAdoptAnimals() {
        return animalRepository.findAllByAdopted(false);
    }

    public void updateAdoptedTrue(String id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));

        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("adopted", true);

        mongoTemplate.updateFirst(query, update, Animal.class);
    }
}
