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

import service.CarrinhoDeCompraService;
import model.CarrinhoDeCompra;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoDeCompraController {

	private final CarrinhoDeCompraService carrinhoDeCompraService;

	public CarrinhoDeCompraController(CarrinhoDeCompraService carrinhoDeCompraService) {
		this.carrinhoDeCompraService = carrinhoDeCompraService;
	}

	@PostMapping
	public ResponseEntity<CarrinhoDeCompra> adicionarCarrinho(@RequestBody CarrinhoDeCompra carrinhoDeCompra) {
		CarrinhoDeCompra novoCarrinho = carrinhoDeCompraService.adicionarCarrinho(carrinhoDeCompra);
		return new ResponseEntity<>(novoCarrinho, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarrinhoDeCompra> getCarrinhoById(@PathVariable Long id) {
		CarrinhoDeCompra carrinhoDeCompra = carrinhoDeCompraService.getCarrinhoById(id);

		if (carrinhoDeCompra != null) {
			return new ResponseEntity<>(carrinhoDeCompra, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<CarrinhoDeCompra> atualizarCarrinho(@PathVariable Long id,
			@RequestBody CarrinhoDeCompra carrinhoDeCompra) {
		CarrinhoDeCompra carrinhoAtualizado = carrinhoDeCompraService.atualizarCarrinho(id, carrinhoDeCompra);

		if (carrinhoAtualizado != null) {
			return new ResponseEntity<>(carrinhoAtualizado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagarCarrinho(@PathVariable Long id) {

		boolean removido = carrinhoDeCompraService.apagarCarrinho(id);

		if (removido) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
