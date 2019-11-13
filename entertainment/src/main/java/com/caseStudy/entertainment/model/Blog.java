package com.caseStudy.entertainment.model;

import javax.persistence.*;

@Entity
@Table(name = "title")

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameTitle;
    private String content;

    public Blog(String nameTitle, String content) {
        this.nameTitle = nameTitle;
        this.content = content;
    }

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
