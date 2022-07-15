package com.sussy.mangashopapi.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sussy.mangashopapi.entity.Author;
import com.sussy.mangashopapi.repository.AuthorRepository;
import com.sussy.mangashopapi.service.declaration.AuthorService;
import com.soosy.mangaapi.Exception.AuthorNotFoundException;
import com.soosy.mangaapi.Exception.InvalidAuthorRequestBodyException;


@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
	@Override
	public Author saveAuthor(Author author) throws InvalidAuthorRequestBodyException{
		try {
            return authorRepository.save(author);
        } catch (Exception e) {
            throw new InvalidAuthorRequestBodyException("Invalid request body");
        }
	}
	@Override
	public Author findAuthorById(Long id) throws AuthorNotFoundException {
        return authorRepository.findById(id).orElseThrow(()->new AuthorNotFoundException("Author not found"));
	}
    @Override
    public Author findAuthorByName(String name) throws AuthorNotFoundException {
        return authorRepository.findAuthorByName(name).orElseThrow(()->new AuthorNotFoundException("Author not found"));
    }
    
}
