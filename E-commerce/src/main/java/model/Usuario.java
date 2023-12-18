package br.edu.iff.Ecommerce.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Usuario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60) 
    private String nome;


    @ElementCollection
    private Collection<Endereco> enderecos;
 
    public Usuario(Long id, String nome, List<Endereco> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.enderecos = enderecos;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}