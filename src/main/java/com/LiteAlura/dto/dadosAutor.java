package com.LiteAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public record dadosAutor(
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") Date dataNascimento,
        @JsonAlias("death_year") Date dataFalecimento) {
}