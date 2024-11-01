package com.animal.adoption.service;

import com.animal.adoption.domain.Article;
import com.animal.adoption.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public void likeIncrease(String id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));

        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("like_num", article.getLike_num() + 1);

        mongoTemplate.updateFirst(query, update, Article.class);
    }
}
