package com.wu.jdbc.controller;

import com.wu.jdbc.pojo.Author;
import com.wu.jdbc.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author/")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    @RequestMapping("findAuthorList")
    public List<Author> findAuthorList() {
        return authorService.findAuthorList();
    }

}