package com.LiteAlura.controller;

import com.LiteAlura.dto.dadosLivro;
import com.LiteAlura.service.ConsumoApi;

public class LivroController {

    ConsumoApi consumo = new ConsumoApi();

    public void buscaLivroApi(String livro) {
        livro = livro.replace(" ", "&20");
        dadosLivro apiDados = new dadosLivro(consumo.obterDados("https://gutendex.com/books/?search="+livro));
    }
}
