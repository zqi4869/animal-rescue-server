package com.animal.adoption.domain;

import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "adoptions")
@Data
public class Adoption {
    @Id
    private ObjectId id;
    private ObjectId user_id;
    private ObjectId animal_id;
    private Date create_time;

    private List<Animal> animalList;
}
