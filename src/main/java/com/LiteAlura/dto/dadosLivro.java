package com.LiteAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record dadosLivro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<dadosAutor> autores,
        @JsonAlias("languages") List<Linguagem> idiomas
) {
    public dadosLivro(String titulo) {
    }
}