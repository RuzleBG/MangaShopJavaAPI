package com.sussy.mangashopapi.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soosy.mangaapi.Exception.MangaNotFoundExcpetion;
import com.sussy.mangashopapi.entity.Author;
import com.sussy.mangashopapi.entity.Manga;
import com.sussy.mangashopapi.repository.MangaRepository;
import com.sussy.mangashopapi.service.declaration.MangaService;
import com.sussy.mangashopapi.repository.AuthorRepository;
import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    @Autowired
    MangaRepository mangaRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Manga saveMangaAndAuthor(Manga manga) {
        Author author= manga.getAuthor();
        Optional<Author> foundAuthor=authorRepository.findAuthorByName(author.getName());
        if(foundAuthor.isPresent()){
            manga.getAuthor().setAuthorId(foundAuthor.get().getAuthorId());
        }
        return mangaRepository.save(manga);
    }

    @Override
    public List<Manga> getAllManga() {
        return mangaRepository.findAll();   
    }

    @Override
    public Manga getMangaById(Long id) throws MangaNotFoundExcpetion{
        return mangaRepository.findById(id).orElseThrow(()->new MangaNotFoundExcpetion("Manga Not found"));
    }

    @Override
    public Manga getManbgaByName(String name) throws MangaNotFoundExcpetion {
        return mangaRepository.findMangaByName(name).orElseThrow(()->new MangaNotFoundExcpetion("Manga not found"));
    }

	@Override
	public void updateMangaVolumes(Long id, Integer chapters) {
        mangaRepository.updateMangaVolumes(id, chapters);
	}

    @Override
    public void deleteManga(Long id) {
        mangaRepository.deleteById(id);        
    }
    
}
