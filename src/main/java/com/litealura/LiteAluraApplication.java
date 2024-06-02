package com.litealura;

import com.litealura.main.Main;
import com.litealura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteAluraApplication implements CommandLineRunner {

	@Autowired
	BookService bookService;


	public static void main(String[] args) {
		SpringApplication.run(LiteAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(bookService);
		main.getMenu();
	}
}