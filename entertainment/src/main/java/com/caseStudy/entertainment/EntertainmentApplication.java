package com.caseStudy.entertainment;

import com.caseStudy.entertainment.service.BlogTitleService;
import com.caseStudy.entertainment.service.impl.BlogTitleServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntertainmentApplication {


    public static void main(String[] args) {
        SpringApplication.run(EntertainmentApplication.class, args);
    }

    @Bean
    public BlogTitleService blogTitleService() {
        return new BlogTitleServiceImpl();
    }
}
