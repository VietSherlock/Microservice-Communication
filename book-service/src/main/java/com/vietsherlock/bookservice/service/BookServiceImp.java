package com.vietsherlock.bookservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.vietsherlock.bookservice.models.Book;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookServiceImp implements BookService{

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImp.class);

    @Override
    public List<Book> bookData(){

        logger.info("The BookServiceImp has been called where the book data is stored");
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setName("Sherlock Holmes");
        book1.setBookAuthor("Conan Doyle");
        books.add(book1);

        Book book2 = new Book();
        book2.setName("Steve Jobs");
        book2.setBookAuthor("Walter Isaacson");
        books.add(book2);

        Book book3 = new Book();
        book3.setName("Harry Potter");
        book3.setBookAuthor("JK");
        books.add(book3);

        return books;
    }

}
