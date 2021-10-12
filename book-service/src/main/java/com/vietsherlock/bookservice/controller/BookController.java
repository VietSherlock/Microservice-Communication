package com.vietsherlock.bookservice.controller;

import com.vietsherlock.bookservice.models.Book;
import com.vietsherlock.bookservice.service.BookService;
import com.vietsherlock.bookservice.service.BookServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.vietsherlock.bookservice.api.LibraryApi;

import java.util.List;

@RestController
public class BookController implements LibraryApi {

    private final BookService bookService;
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookServiceImp bookServiceImp){
        this.bookService = bookServiceImp;
    }

    @Override
    public ResponseEntity<List<Book>> getAllBooksInLibrary() {
        logger.info("book-service controller is called!");
        return new ResponseEntity<>(bookService.bookData(), HttpStatus.OK) ;
    }
}
