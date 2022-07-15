package com.sussy.mangashopapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.soosy.mangaapi.Exception.MangaNotFoundExcpetion;
import com.sussy.mangashopapi.entity.Manga;
import com.sussy.mangashopapi.service.declaration.MangaService;

@RestController
public class MangaController {
    @Autowired
    MangaService mangaService;

    @PostMapping("/manga")
    public Manga saveManga(@RequestBody Manga manga){
        return mangaService.saveMangaAndAuthor(manga);
    }
    @GetMapping("/manga")
    public List<Manga> getAllManga(){
        return mangaService.getAllManga();
    }
    @GetMapping("/manga/id/{id}")
    public Manga getMangaById(@PathVariable("id") Long id) throws MangaNotFoundExcpetion{
        return mangaService.getMangaById(id);
    }
    @GetMapping("/manga/{title}") 
    public Manga getMangaByName(@PathVariable("title") String name) throws MangaNotFoundExcpetion{
        return mangaService.getManbgaByName(name);
    }
    @Transactional
    @PutMapping("/manga/{id}/{volumes}")
    public void updateMangaVolumes(@PathVariable("id") Long id, @PathVariable("volumes") Integer chapters) {
        mangaService.updateMangaVolumes(id, chapters);
    }
    @DeleteMapping("/manga/{id}")
    public void deleteManga(@PathVariable("id") Long id){
        mangaService.deleteManga(id);
    }
}
