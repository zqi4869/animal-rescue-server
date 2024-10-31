package com.animal.adoption.domain;

import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "articles")
@Data
public class Article {
    @Id
    private ObjectId id;
    private String title;
    private ObjectId user_id;
    private String content;
    private String img_url;
    private Integer like_num;
    private Integer comment_num;
    private Date create_time;

    private User user;
}
