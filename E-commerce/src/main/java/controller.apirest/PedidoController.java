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

import model.Pedido;
import service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@PostMapping
	public ResponseEntity<Pedido> adicionarPedido(@RequestBody Pedido pedido) {
		Pedido novoPedido = pedidoService.adicionarPedido(pedido);
		return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
		Pedido pedido = pedidoService.getPedidoById(id);

		if (pedido != null) {
			return new ResponseEntity<>(pedido, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
		Pedido pedidoAtualizado = pedidoService.atualizarPedido(id, pedido);

		if (pedidoAtualizado != null) {
			return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagarPedido(@PathVariable Long id) {
		boolean removido = pedidoService.apagarPedido(id);

		if (removido) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}