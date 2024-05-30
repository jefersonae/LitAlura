package com.LiteAlura.view;

import java.util.Scanner;

public class Menu {

    Scanner ler = new Scanner(System.in);

    public byte exibeMenuInicial() {

        System.out.print("""
                ***********************************************
                                   LiteAlura
                ***********************************************
                Menu de opções:
                1 - Buscar livro pelo nome
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros em um determinado idioma
                0 - Sair
                """);
        return ler.nextByte();
    }

    public String exibeMenuCadastroLivro() {
        System.out.print("""
                ---------Cadastrar novo Livro---------
                Entre com o nome do livro:
                """);
        ler.nextLine();
        return ler.nextLine();
    }
}
