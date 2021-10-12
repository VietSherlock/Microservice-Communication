package com.vietsherlock.libraryservice;

import com.vietsherlock.libraryservice.restclient.invoker.ApiClient;
import com.vietsherlock.libraryservice.restclient.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibraryServiceApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

}
