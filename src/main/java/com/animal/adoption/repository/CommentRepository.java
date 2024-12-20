package com.animal.adoption.repository;

import com.animal.adoption.domain.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    @Aggregation(pipeline = {
            "{$lookup:{from: 'users',localField: 'user_id',foreignField: '_id',as: 'user'}}",
            "{$unwind:{path: '$user'}}",
            "{$match:{article_id: ?0}}",
            "{$sort:{create_time:-1}}"
    })
    List<Comment> findAllByArticle(ObjectId articleId);
}



