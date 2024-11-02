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
    private String id;
    private ObjectId user_id;
    private String title = "";
    private String content = "";
    private String img_url = "";
    private Integer like_num = 0;
    private Integer comment_num = 0;
    private Date create_time = new Date();

    private User user;
    private String userId;

    public String getUserId() {
        return user_id.toHexString();
    }

    public void setUserId(String userId) {
        this.user_id = new ObjectId(userId);
        this.userId = userId;
    }
}
