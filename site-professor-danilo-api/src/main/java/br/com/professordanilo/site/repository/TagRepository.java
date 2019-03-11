package br.com.professordanilo.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.professordanilo.site.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
