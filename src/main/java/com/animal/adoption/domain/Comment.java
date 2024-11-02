package com.animal.adoption.domain;

import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "comments")
@Data
public class Comment {
    @Id
    private String id;
    private ObjectId user_id;
    private ObjectId article_id;
    private String comment = "";
    private Date create_time = new Date();

    private User user;

    private String userId;
    private String articleId;

    public String getUserId() {
        return user_id.toHexString();
    }

    public void setUserId(String userId) {
        this.user_id = new ObjectId(userId);
        this.userId = userId;
    }

    public String getArticleId() {
        return article_id.toHexString();
    }

    public void setArticleId(String articleId) {
        this.article_id = new ObjectId(articleId);
        this.articleId = articleId;
    }
}
