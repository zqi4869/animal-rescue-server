package com.animal.adoption.repository;

import com.animal.adoption.domain.Adoption;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AdoptionRepository extends MongoRepository<Adoption, String> {

    @Aggregation(pipeline = {
            "{$lookup:{from: 'animals',localField: 'animal_id',foreignField: '_id',as: 'animalList'}}",
            "{$match:{user_id: ?0}}"
    })
    List<Adoption> findMyAdoptions(ObjectId userId);
}



