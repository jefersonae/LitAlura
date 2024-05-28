package com.LiteAlura;

import com.LiteAlura.view.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Menu menu = new Menu();
		byte opcao = -3;

		while (opcao != 0){
			opcao = menu.exibeMenuInicial();
		}
	}
}