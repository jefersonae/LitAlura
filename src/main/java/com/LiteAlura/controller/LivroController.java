package com.LiteAlura.controller;

import com.LiteAlura.service.ConsumoApi;

public class LivroController {

    ConsumoApi consumo = new ConsumoApi();

    public void buscaLivroApi(String livro) {

        consumo.obterDados("gutendex.com/books/?search="+livro);
    }
}
