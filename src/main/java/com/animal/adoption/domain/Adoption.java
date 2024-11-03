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
    private String id;
    private ObjectId user_id;
    private ObjectId animal_id;
    private Date create_time = new Date();

    private Animal animal;
    private String userId;
    private String animalId;

    public String getAnimalId() {
        return animal_id.toHexString();
    }

    public void setAnimalId(String animalId) {
        this.animal_id = new ObjectId(animalId);
        this.animalId = animalId;
    }

    public String getUserId() {
        return user_id.toHexString();
    }

    public void setUserId(String userId) {
        this.user_id = new ObjectId(userId);
        this.userId = userId;
    }
}
