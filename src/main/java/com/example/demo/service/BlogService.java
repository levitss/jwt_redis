package com.example.demo.service;

import com.example.demo.domain.Article;
import com.example.demo.dto.AddArticleRequest;
import com.example.demo.dto.UpdateArticleRequest;
import com.example.demo.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article save(AddArticleRequest addArticleRequest, String userName) {
        Article save = blogRepository.save(addArticleRequest.toEntity(userName));

        return save;
    }

    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found"));
    }
    public void delete(Long id) {
        blogRepository.delete(findById(id));
    }

    public Article update(Long id, UpdateArticleRequest updateArticleRequest) {
        Article byId = findById(id);
        byId.update(updateArticleRequest.getTitle(), updateArticleRequest.getContent());
        return byId;
    }

    private void authorizeArticleAuthor(Article article) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

    }

}
