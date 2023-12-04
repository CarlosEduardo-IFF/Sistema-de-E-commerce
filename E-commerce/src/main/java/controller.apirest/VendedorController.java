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

import model.ContaVendedor;
import service.ContaVendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

	private ContaVendedorService contaVendedorService = new ContaVendedorService();

	public void ContaVendedorController(ContaVendedorService contaVendedorService) {
		this.contaVendedorService = contaVendedorService;
	}

	@PostMapping
	public ResponseEntity<ContaVendedor> adicionarContaVendedor(@RequestBody ContaVendedor contaVendedor) {
		ContaVendedor novaContaVendedor = contaVendedorService.adicionarContaVendedor(contaVendedor);
		return new ResponseEntity<>(novaContaVendedor, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaVendedor> getContaVendedorById(@PathVariable Long id) {
		ContaVendedor contaVendedor = contaVendedorService.getContaVendedorById(id);

		if (contaVendedor != null) {
			return new ResponseEntity<>(contaVendedor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContaVendedor> atualizarContaVendedor(@PathVariable Long id,
			@RequestBody ContaVendedor contaVendedor) {
		ContaVendedor contaVendedorAtualizada = contaVendedorService.atualizarContaVendedor(id, contaVendedor);

		if (contaVendedorAtualizada != null) {
			return new ResponseEntity<>(contaVendedorAtualizada, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagarContaVendedor(@PathVariable Long id) {
		boolean removida = contaVendedorService.apagarContaVendedor(id);

		if (removida) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
