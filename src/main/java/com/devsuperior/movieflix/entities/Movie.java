package com.devsuperior.movieflix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subTitle;

    private String synopsis;

    private Integer year;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Genre genre;

    @OneToMany(mappedBy = "movie")
    private Set<Review> reviews = new HashSet<>();
}
