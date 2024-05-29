package com.LiteAlura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date anoNascimento;
    private Date anoFalecimento;
    @OneToMany(mappedBy = "autores" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Date anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Date getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Date anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
