package com.animal.adoption.controller;

import com.animal.adoption.domain.Comment;
import com.animal.adoption.service.ArticleService;
import com.animal.adoption.service.CommentService;
import com.animal.adoption.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/all")
    public RestResult findAll(String articleId) {
        return RestResult.success(commentService.findAll(articleId));
    }

    @PostMapping("/save")
    public RestResult save(@RequestBody Comment comment) {
        commentService.save(comment);
        articleService.commentNumIncr(comment.getArticleId());
        return RestResult.success();
    }

}
