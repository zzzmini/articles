package com.my.articles.service;

import com.my.articles.dao.ArticleDAO;
import com.my.articles.dto.ArticleDTO;
import com.my.articles.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleDAO dao;

    public List<ArticleDTO> getAllArticle() {
        List<Article> articles = dao.getAllArticle();
        if(ObjectUtils.isEmpty(articles)) {
            return Collections.emptyList();
        }
        List<ArticleDTO> dtoList = articles
                .stream().map(x -> ArticleDTO.fromArticle(x))
                .toList();
        return  dtoList;
    }

    public ArticleDTO getOneArticle(Long id) {
        Article article = dao.getOneArticle(id);
        if(ObjectUtils.isEmpty(article)) return null;
        return ArticleDTO.fromArticle(article);
    }

    public void deleteArticle(Long id) {
        dao.deleteArticle(id);
    }

    public void updateArticle(ArticleDTO dto) {
        dao.updateArticle(dto);
    }

    public void insertArticle(ArticleDTO dto) {
        dao.insertArticle(ArticleDTO.fromDto(dto));
    }
}
