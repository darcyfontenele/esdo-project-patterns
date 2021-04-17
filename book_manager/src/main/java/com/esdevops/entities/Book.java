package com.esdevops.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="summary")
    private String summary;

    @Column(name="release_year")
    private Integer releaseYear;

    public Book(String title, String author, String summary, Integer releaseYear) {
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.releaseYear = releaseYear;
    }

}
