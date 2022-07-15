package com.sussy.mangashopapi.service.declaration;

import java.util.List;

import com.soosy.mangaapi.Exception.AuthorNotFoundException;
import com.soosy.mangaapi.Exception.InvalidAuthorRequestBodyException;
import com.sussy.mangashopapi.entity.Author;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author saveAuthor(Author author) throws InvalidAuthorRequestBodyException;

    Author findAuthorById(Long id) throws AuthorNotFoundException;

    Author findAuthorByName(String name) throws AuthorNotFoundException;
    
}
