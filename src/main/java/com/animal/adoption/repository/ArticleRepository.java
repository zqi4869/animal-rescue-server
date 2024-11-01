package com.animal.adoption.repository;

import com.animal.adoption.domain.Article;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {
    @Aggregation(pipeline = {
            "{$lookup:{from: 'users',localField: 'user_id',foreignField: '_id',as: 'user'}}",
            "{$unwind:{path: '$user'}}"
    })
    public List<Article> findAll();

}



