package br.com.professordanilo.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.professordanilo.site.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
