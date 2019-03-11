package br.com.professordanilo.site.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.professordanilo.site.model.Usuario;
import br.com.professordanilo.site.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController extends CrudController<Usuario, Long, UsuarioRepository>{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Usuario adicionar(@Valid Usuario entity) {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return super.adicionar(entity);
	}
	
	@GetMapping(path="/code", params = { "code" })
	public String codar(@RequestParam("code") String code){
		return passwordEncoder.encode(code);
	}
	
}
