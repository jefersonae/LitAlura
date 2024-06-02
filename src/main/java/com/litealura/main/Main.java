package com.litealura.main;

import com.litealura.model.*;
import com.litealura.service.BookService;
import com.litealura.service.ConsumingApi;
import com.litealura.service.ConvertData;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsumingApi consumingApi = new ConsumingApi();
    private final ConvertData converter = new ConvertData();
    private final BookService bookService;

// CONSTRUCTOR
    public Main(BookService bookService) {
        this.bookService = bookService;
    }

    // METHOD
    public void getMenu() {
        String menu = """
                *****************************************
                                LITEALURA
                1 - Buscar livros
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um ano
                5 - Listar livros na linguagem
                
                0 - Sair
                *****************************************
                """;
        int option = -1;

        while ( option != 0 ) {
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch ( option ) {
                case 1:
                    getBook();
                    break;
                case 2:
                    getAllBooks();
                    break;
                case 3:
                    getAllAuthors();
                    break;
                case 4:
                    getAuthorsAliveIn();
                    break;
                case 5:
                    getBooksByLanguage();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        }

    }

// CASE 1
    private BookData getBookData() {
        String apiUrlStart = "https://gutendex.com//books?search=";
        System.out.println("Insira o nome do livro: ");
        String bookTitle = scanner.nextLine();

        var bookJson = consumingApi.getApiData(apiUrlStart + bookTitle.toLowerCase().replace(" ", "%20"));
        ResultsData resultsData = converter.getData(bookJson, ResultsData.class);
        BookData bookData = resultsData.results().get(0);

        return bookData;
    }
    private void getBook() {
        BookData bookData = getBookData();
        Book book = new Book(bookData);

        // getting the first author in the array inside bookData and putting him into the Author class
        var firstAuthor = bookData.authors().get(0);
        AuthorData authorData = new AuthorData(firstAuthor.name(), firstAuthor.birth_year(), firstAuthor.death_year());
        Author author = new Author(authorData);

        book.setAuthor(author);
        bookService.saveBook(book);
        System.out.println(book);
    }

// CASE 2
    private void getAllBooks() {
        var books = bookService.getAllBooks();
        if(!books.isEmpty()) {
            books.forEach(System.out::println);
        } else {
            System.out.println("Não há nenhum livro registrado");
        }
    }

// CASE 3
    private void getAllAuthors() {
        var authors = bookService.getAllAuthors();
        if(!authors.isEmpty()) {
            authors.forEach(System.out::println);
        } else {
            System.out.println("Não há nenhum autor registrado");
        }
    }

// CASE 4
    private void getAuthorsAliveIn() {
        System.out.println("Digite o ano que deseja pesquisar: ");
        String year = scanner.nextLine();

        var authorsAliveIn = bookService.getAuthorsAliveIn(year);
        if(!authorsAliveIn.isEmpty()) {
            authorsAliveIn.forEach(System.out::println);
        } else {
            System.out.println("Não há nenhum autor registrado vivo nesse ano");
        }
    }

// CASE 5
    private void getBooksByLanguage() {
        var booksByLanguage = bookService.getBooksByLanguage();
        booksByLanguage.forEach(System.out::println);
    }
}
