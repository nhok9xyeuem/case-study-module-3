package com.caseStudy.entertainment.repository;

import com.caseStudy.entertainment.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogTitleRepository extends PagingAndSortingRepository<Blog,Long>{
}
