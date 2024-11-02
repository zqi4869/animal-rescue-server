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

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }

    public void likeIncr(String id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));

        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("like_num", article.getLike_num() + 1);

        mongoTemplate.updateFirst(query, update, Article.class);
    }

    public void commentNumIncr(String id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));

        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("comment_num", article.getComment_num() + 1);

        mongoTemplate.updateFirst(query, update, Article.class);
    }
}
