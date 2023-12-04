package controller.apirest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Categoria;
import service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private final CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping
	public ResponseEntity<Categoria> adicionarCategoria(@RequestBody Categoria categoria) {
		Categoria novaCategoria = categoriaService.adicionarCategoria(categoria);
		return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
		Categoria categoria = categoriaService.getCategoriaById(id);

		if (categoria != null) {
			return new ResponseEntity<>(categoria, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
		Categoria categoriaAtualizada = categoriaService.atualizarCategoria(id, categoria);

		if (categoriaAtualizada != null) {
			return new ResponseEntity<>(categoriaAtualizada, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagarCategoria(@PathVariable Long id) {
		boolean removida = categoriaService.apagarCategoria(id);

		if (removida) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}