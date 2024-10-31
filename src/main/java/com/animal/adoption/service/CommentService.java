package com.animal.adoption.service;

import com.animal.adoption.domain.Comment;
import com.animal.adoption.repository.CommentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

	@Autowired
    private CommentRepository commentRepository;

    public List<Comment> findAll(String articleId) {
        return commentRepository.findAllByArticle(new ObjectId(articleId));
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
