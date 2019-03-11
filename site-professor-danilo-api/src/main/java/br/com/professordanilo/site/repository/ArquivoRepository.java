package br.com.professordanilo.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.professordanilo.site.model.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{

}
