package com.sussy.mangashopapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "mangas")
@Table(name = "author")
public class Author {
    @SequenceGenerator(
        name = "author_sequence_generator",
        initialValue = 1,
        allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "author_sequence_generator")
    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "author")
    private List<Manga> mangas;

}
