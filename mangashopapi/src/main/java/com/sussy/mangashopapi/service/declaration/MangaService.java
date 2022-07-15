package com.sussy.mangashopapi.service.declaration;

import java.util.List;

import com.soosy.mangaapi.Exception.MangaNotFoundExcpetion;
import com.sussy.mangashopapi.entity.Manga;

public interface MangaService {

    Manga saveMangaAndAuthor(Manga manga);

    List<Manga> getAllManga();

    Manga getMangaById(Long id) throws MangaNotFoundExcpetion;

    Manga getManbgaByName(String name) throws MangaNotFoundExcpetion;

    void updateMangaVolumes(Long id, Integer chapters);

    void deleteManga(Long id);
    
}
