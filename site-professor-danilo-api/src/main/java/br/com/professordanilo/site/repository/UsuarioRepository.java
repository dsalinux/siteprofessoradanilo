package br.com.professordanilo.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.professordanilo.site.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
	
}
