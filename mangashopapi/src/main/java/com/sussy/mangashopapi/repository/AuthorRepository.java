package com.sussy.mangashopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.sussy.mangashopapi.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
    @Query(value = "SELECT * FROM author WHERE name=?1", nativeQuery = true)
    public Optional<Author> findAuthorByName(String name);
}
