package controller.apirest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import model.Endereco;
import service.EnderecoService;

public class EnderecoController {

	private final EnderecoService enderecoService;

	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	@PostMapping
	public ResponseEntity<Endereco> adicionarEndereco(@RequestBody Endereco endereco) {
		Endereco novoEndereco = enderecoService.adicionarEndereco(endereco);
		return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
		Endereco endereco = enderecoService.getEnderecoById(id);

		if (endereco != null) {
			return new ResponseEntity<>(endereco, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
		Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, endereco);

		if (enderecoAtualizado != null) {
			return new ResponseEntity<>(enderecoAtualizado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagarEndereco(@PathVariable Long id) {
		boolean removido = enderecoService.apagarEndereco(id);

		if (removido) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
