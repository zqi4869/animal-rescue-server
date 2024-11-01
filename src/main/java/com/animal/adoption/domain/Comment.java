package com.animal.adoption.domain;

import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "comments")
@Data
public class Comment extends BaseDomain{
    @Id
    private String id;
    private String user_id;
    private String article_id;
    private String comment;
    private Date create_time = new Date();

    private User user;
}
