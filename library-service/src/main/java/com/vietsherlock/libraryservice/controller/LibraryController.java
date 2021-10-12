package com.vietsherlock.libraryservice.controller;

import com.vietsherlock.libraryservice.mapper.BookMapper;
import com.vietsherlock.libraryservice.restclient.invoker.ApiClient;
//import com.vietsherlock.libraryservice.restclient.model.Book;
import  com.vietsherlock.libraryservice.server.models.Book;
import com.vietsherlock.libraryservice.server.api.LibraryApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.vietsherlock.libraryservice.mapper.BookMapperImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController implements LibraryApi {

    private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);

    @Override
    public ResponseEntity<List<Book>> getAllBooksInLibrary() {

        logger.info("LibraryController is called!");

        List<Book> book_servers = new ArrayList<>();
        List<com.vietsherlock.libraryservice.restclient.model.Book> book_clients = new ArrayList<>();

        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8081");
        book_clients = new com.vietsherlock.libraryservice.restclient.api.LibraryApi(apiClient).getAllBooksInLibrary();

        logger.info("book data get from book-service: " + book_clients);

        BookMapper bookMapper = new BookMapperImpl();
        for(com.vietsherlock.libraryservice.restclient.model.Book book: book_clients){
            book_servers.add(bookMapper.bookClientToBookServer(book));
        }

        return new ResponseEntity<>(book_servers, HttpStatus.OK);
    }
}
