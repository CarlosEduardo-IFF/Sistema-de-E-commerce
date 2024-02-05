package br.edu.iff.ecommerce.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ecommerce.model.ContaCliente;
import br.edu.iff.ecommerce.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService contaClienteService;
    
    @PostMapping("")
    public ResponseEntity<Object> criarCliente(@RequestParam String email, @RequestParam String senha, @RequestParam String nomeUsuario, @RequestParam String cpf) {
        try {
            ContaCliente novaContaCliente = contaClienteService.criarContaCliente(email, senha, nomeUsuario, cpf);
            return new ResponseEntity<>("Cliente criado com sucesso. ID: " + novaContaCliente.getId(), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerCliente(@PathVariable Long id) {
        contaClienteService.removerCliente(id);
        return new ResponseEntity<>("Cliente removido com sucesso", HttpStatus.OK);
    }

    @PutMapping("/alterarCredito/{id}")
    public ResponseEntity<Object> alterarCredito(@PathVariable Long id, @RequestParam double novoCredito) {
        contaClienteService.alterarCredito(id, novoCredito);
        return new ResponseEntity<>("Crédito alterado com sucesso", HttpStatus.OK);
    }

    @PutMapping("/alterarNome/{id}")
    public ResponseEntity<Object> alterarNome(@PathVariable Long id, @RequestParam String novoNome) {
        contaClienteService.alterarNome(id, novoNome);
        return new ResponseEntity<>("Nome alterado com sucesso", HttpStatus.OK);
    }
    

}
