package com.sussy.mangashopapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sussy.mangashopapi.entity.Author;
import com.sussy.mangashopapi.entity.Manga;

@SpringBootTest
public class AuthrorRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void testSave(){
        Author author=Author.builder().name("junji ito").build();
        authorRepository.save(author);
    }
}
