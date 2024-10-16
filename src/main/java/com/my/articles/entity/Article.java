package com.my.articles.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 1000)
    private String content;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "article",
            cascade = {CascadeType.PERSIST,
                CascadeType.REMOVE})
    List<Comment> comments = new ArrayList<>();

}
