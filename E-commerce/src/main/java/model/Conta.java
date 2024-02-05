package br.edu.iff.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Conta{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id_conta")
    private Long id;
	
	@Column(name = "col_nome", length = 60) 
    private String nomeUsuario;
	
    @Column(name = "col_email", nullable = false, length = 255)
    private String email;

    @Column(name = "col_senha", nullable = false)
    private String senha;

    public Conta() {

	}

    public Conta(String email, String senha, String nomeUsuario) {
		this.email = email;
		this.senha = senha;
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

    
}