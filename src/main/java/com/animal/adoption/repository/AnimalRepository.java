package com.animal.adoption.repository;

import com.animal.adoption.domain.Animal;
import com.animal.adoption.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimalRepository extends MongoRepository<Animal, String> {
    public List<Animal> findAllByAdopted(boolean adopted);
}
