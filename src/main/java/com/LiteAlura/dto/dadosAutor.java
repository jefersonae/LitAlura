package com.LiteAlura.dto;

import java.util.Date;

public record dadosAutor(
        String name, Date dataNascimento, Date dataFalecimento) {
}
