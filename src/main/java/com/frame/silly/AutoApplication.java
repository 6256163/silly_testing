package com.frame.silly;

import com.frame.silly.com.frame.entity.Page;
import com.frame.silly.com.frame.repository.ElementRepository;
import com.frame.silly.com.frame.repository.PageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(PageRepository repository) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
//                repository.save(new Page("aaa"));
				System.err.println(repository.findAll());
			}

		};
	}
}
