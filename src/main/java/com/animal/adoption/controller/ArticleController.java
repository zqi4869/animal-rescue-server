package com.animal.adoption.controller;

import com.animal.adoption.service.ArticleService;
import com.animal.adoption.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/all")
    public RestResult findAll() {
        return RestResult.success(articleService.findAll());
    }

}
