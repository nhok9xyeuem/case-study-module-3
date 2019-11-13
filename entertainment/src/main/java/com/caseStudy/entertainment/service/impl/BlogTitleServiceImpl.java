package com.caseStudy.entertainment.service.impl;

import com.caseStudy.entertainment.model.Blog;
import com.caseStudy.entertainment.repository.BlogTitleRepository;
import com.caseStudy.entertainment.service.BlogTitleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogTitleServiceImpl implements BlogTitleService {

    @Autowired
    private BlogTitleRepository blogTitleRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogTitleRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogTitleRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogTitleRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogTitleRepository.deleteById(id);
    }

}
