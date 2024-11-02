package com.animal.adoption.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String role = "user";
    private String avatar = "";
    private String first_name = "";
    private String last_name = "";
    private String phone = "";
    private String address = "";
    private String city = "";
}
