package com.movieappraiser.entity;


import javax.persistence.*;

@Entity
@Table(name = "movie_rating")
public class MovieRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "appraisers_name")
    private String appraisersName;

    @Column(nullable = false)
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppraisersName() {
        return appraisersName;
    }

    public void setAppraisersName(String appraisersName) {
        this.appraisersName = appraisersName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
