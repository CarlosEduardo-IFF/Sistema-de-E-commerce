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

import service.ClienteService;
import model.ContaCliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<ContaCliente> adicionarCliente(@RequestBody ContaCliente cliente) {
		ContaCliente novoCliente = clienteService.adicionarCliente(cliente);
		return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaCliente> getClienteById(@PathVariable Long id) {
		ContaCliente cliente = clienteService.getClienteById(id);

		if (cliente != null) {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContaCliente> atualizarCliente(@PathVariable Long id, @RequestBody ContaCliente cliente) {
		ContaCliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);

		if (clienteAtualizado != null) {
			return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagarCliente(@PathVariable Long id) {
		boolean removido = clienteService.apagarCliente(id);

		if (removido) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
