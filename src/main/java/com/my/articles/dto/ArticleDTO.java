package com.my.articles.dto;

import com.my.articles.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;

    public static ArticleDTO fromArticle(Article article) {
        return new ArticleDTO(
                article.getId(),
                article.getTitle(),
                article.getContent());
    }

    public static Article fromDto(ArticleDTO dto) {
        Article article = new Article();
        article.setId(dto.getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        return article;
    }
}
