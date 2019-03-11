package br.com.professordanilo.site.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.professordanilo.site.model.Post;
import br.com.professordanilo.site.repository.PostRepository;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController extends CrudController<Post, Long, PostRepository>{

}
