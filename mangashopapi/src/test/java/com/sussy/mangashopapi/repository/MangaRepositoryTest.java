package com.sussy.mangashopapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import com.sussy.mangashopapi.entity.Author;
import com.sussy.mangashopapi.entity.Manga;

@SpringBootTest
public class MangaRepositoryTest {

    @Autowired
    MangaRepository mangaRepository;

    @Test
    public void testSave(){
        Manga manga=Manga.builder().title("Jojo's bizzare adventure").chapters(1370).releaseYear("1992").build();
        Author author= Author.builder().name("Hirohiko Araki").build();
        manga.setAuthor(author);

        mangaRepository.save(manga);

    }
}
