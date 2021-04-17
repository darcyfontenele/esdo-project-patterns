package com.movieappraiser.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String synopsis;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "producer_name")
    private String producerName;

    @Column(name = "protagonists_name")
    private String protagonistsName;

    @Transient
    private Double averageRating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProtagonistsName() {
        return protagonistsName;
    }

    public void setProtagonistsName(String protagonistsName) {
        this.protagonistsName = protagonistsName;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

}
