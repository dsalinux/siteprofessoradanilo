package br.com.professordanilo.site.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CrudController<E, ID, R extends JpaRepository<E, ID>> {

	@Autowired
	private R repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public E adicionar(@Valid @RequestBody E entity) {
		return repository.save(entity);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable ID id) {
		repository.deleteById(id);
	}
	
	@GetMapping
	public List<E> listar(){
		return repository.findAll();
	}
	
	@GetMapping(params = { "page", "size" })
	public Page<E> listar(@RequestParam("page") int page, @RequestParam("size") int size){
		return repository.findAll(PageRequest.of(page, size));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<E> buscar(@PathVariable ID id) {
		Optional<E> optional = repository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	public R getRepository() {
		return repository;
	}
	
}
