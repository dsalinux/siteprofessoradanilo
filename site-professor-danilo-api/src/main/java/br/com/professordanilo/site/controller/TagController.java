package br.com.professordanilo.site.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.professordanilo.site.model.Tag;
import br.com.professordanilo.site.repository.TagRepository;

@CrossOrigin
@RestController
@RequestMapping("/tag")
public class TagController extends CrudController<Tag, Long, TagRepository>{

//	@Autowired
//	private CategoriaRepository repository;
//	
//	@GetMapping
//	public List<Categoria> list(){
//		return repository.findAll();
//	}
//	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Categoria adicionar(@RequestBody Categoria categoria) {
//		return repository.save(categoria);
//	}
	
}
