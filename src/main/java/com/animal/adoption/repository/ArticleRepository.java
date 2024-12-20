package com.animal.adoption.repository;

import com.animal.adoption.domain.Article;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {
    @Aggregation(pipeline = {
            "{$lookup:{from: 'users',localField: 'user_id',foreignField: '_id',as: 'user'}}",
            "{$unwind:{path: '$user'}}",
            "{$sort:{create_time:-1}}"
    })
    public List<Article> findAll();

}



