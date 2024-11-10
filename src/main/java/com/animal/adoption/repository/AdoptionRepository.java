package com.animal.adoption.repository;

import com.animal.adoption.domain.Adoption;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AdoptionRepository extends MongoRepository<Adoption, String> {

    @Aggregation(pipeline = {
            "{$lookup:{from: 'animals',localField: 'animal_id',foreignField: '_id',as: 'animal'}}",
            "{$unwind:{path: '$animal'}}",
            "{$match:{user_id: ?0}}"
    })
    List<Adoption> findMyAdoptions(ObjectId userId);

    @Aggregation(pipeline = {
            "{$lookup:{from: 'animals',localField: 'animal_id',foreignField: '_id',as: 'animal'}}",
            "{$lookup:{from: 'users',localField: 'user_id',foreignField: '_id',as: 'user'}}",
            "{$unwind:{path: '$user'}}",
            "{$unwind:{path: '$animal'}}"
    })
    List<Adoption> findAllAdoptions();
}



