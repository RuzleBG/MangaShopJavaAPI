package com.sussy.mangashopapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.sussy.mangashopapi.entity.Author;
import com.sussy.mangashopapi.entity.Manga;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
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

    @Test
    public void whenGivenTitle_ShouldReturnManga(){
        Manga manga=mangaRepository.findMangaByName("Dororo").get();
        assertEquals("tezuka osamu", manga.getAuthor().getName());
        
    }

    @Test
    public void getAllManga(){
       List<Manga> mangas=mangaRepository.findAll();
        System.out.println(mangas);
    }

    @Test 
    public void whenGivenId_ShouldReturnMangaWithSameId(){
        Long id=23L;
        assertEquals(id, mangaRepository.findById(id).get().getMangaId());
    }
    
}
