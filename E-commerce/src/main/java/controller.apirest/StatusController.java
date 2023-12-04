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

import service.StatusService;
import model.Status;

@RestController
@RequestMapping("/status")
public class StatusController {

	private final StatusService statusService;

	public StatusController(StatusService statusService) {
		this.statusService = statusService;
	}

	@PostMapping
	public ResponseEntity<Status> adicionarStatus(@RequestBody Status status) {
		Status novoStatus = statusService.adicionarStatus(status);
		return new ResponseEntity<>(novoStatus, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
		Status status = statusService.getStatusById(id);

		if (status != null) {
			return new ResponseEntity<>(status, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Status> atualizarStatus(@PathVariable Long id, @RequestBody Status status) {
		Status statusAtualizado = statusService.atualizarStatus(id, status);

		if (statusAtualizado != null) {
			return new ResponseEntity<>(statusAtualizado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagarStatus(@PathVariable Long id) {
		boolean removido = statusService.apagarStatus(id);

		if (removido) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
