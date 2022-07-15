package com.sussy.mangashopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.sussy.mangashopapi.entity.Manga;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long>{

    @Query(value = "SELECT * FROM manga WHERE title =?1", nativeQuery = true)
    public Optional<Manga> findMangaByName(String name);

    @Modifying
    @Query(value = "UPDATE manga SET chapters=?2 WHERE manga_id=?1", nativeQuery = true)
    public void updateMangaVolumes(Long id, Integer chapters);
    
}
