package com.caseStudy.entertainment.service;

import com.caseStudy.entertainment.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogTitleService {
    List<Blog> findAll();

    Blog  findById(Long id);

    void save(Blog blog);

    void remove(Long id);

}
