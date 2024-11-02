package com.animal.adoption.domain;

import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "animals")
@Data
public class Animal {
    @Id
    private String id;
    private String name = "";
    private String gender = "";
    private String no = "";
    private String age = "";
    private String city = "";
    private String label = "";
    private String remark = "";
    private String story = "";
    private String cover_url = "";
    private String story_img_url = "";
    private boolean adopted = false;
}
