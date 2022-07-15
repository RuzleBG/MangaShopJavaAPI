package com.sussy.mangashopapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.soosy.mangaapi.Exception.AuthorNotFoundException;
import com.soosy.mangaapi.Exception.InvalidAuthorRequestBodyException;
import com.sussy.mangashopapi.entity.Author;
import com.sussy.mangashopapi.service.declaration.AuthorService;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
       return authorService.getAllAuthors();
    }

    @PostMapping("/authors")
    public Author saveAuthor(@RequestBody Author author) throws InvalidAuthorRequestBodyException{
        return authorService.saveAuthor(author);
    }

    @GetMapping("/author/{id}")
    public Author findAuthorById(@PathVariable("id") Long id) throws AuthorNotFoundException{
        return authorService.findAuthorById(id);
    }
    
    @GetMapping("/author/{name}")
    public Author findAuthorByNmae(@PathVariable("name") String name) throws AuthorNotFoundException{
        return authorService.findAuthorByName(name);
    }
}
