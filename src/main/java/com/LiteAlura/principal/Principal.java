package com.LiteAlura.principal;

import com.LiteAlura.controller.LivroController;
import com.LiteAlura.view.Menu;

public class Principal {

    private final Menu menu = new Menu();
    private LivroController livroController = new LivroController();
    private byte opcao = -3;

    public void inicial(){
        while (opcao != 0){
            opcao = menu.exibeMenuInicial();
            switch (opcao){
                case 1:
                    String livro = menu.exibeMenuCadastroLivro();
                    livroController.buscaLivroApi(livro);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválidada!");
                    break;
            }
        }
    }
}
