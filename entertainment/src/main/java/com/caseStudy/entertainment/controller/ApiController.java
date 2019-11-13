package com.caseStudy.entertainment.controller;

import com.caseStudy.entertainment.model.Blog;
import com.caseStudy.entertainment.service.BlogTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ApiController {

    @Autowired
    BlogTitleService blogTitleService;

    //-------------------Retrieve All Customers--------------------------------------------------------

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllCustomers() {
        List<Blog> blogs = blogTitleService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    //-------------------Retrieve Single Customer--------------------------------------------------------

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getCustomer(@PathVariable("id") long id) {
        Blog blog = blogTitleService.findById(id);
        if (blog==null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    //-------------------Create a Customer--------------------------------------------------------

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        blogTitleService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/create/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Customer --------------------------------------------------------

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Blog> updateCustomer(@PathVariable("id") long id, @RequestBody Blog blog) {

        Blog currentBlog = blogTitleService.findById(id);

        if (currentBlog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        currentBlog.setNameTitle(blog.getNameTitle());
        currentBlog.setContent(blog.getContent());

        blogTitleService.save(currentBlog);
        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
    }

    //------------------- Delete a Customer --------------------------------------------------------

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteCustomer(@PathVariable("id") long id) {

        Blog blog = blogTitleService.findById(id);
        if (blog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        blogTitleService.remove(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }

}
