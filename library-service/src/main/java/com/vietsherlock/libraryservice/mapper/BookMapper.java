package com.vietsherlock.libraryservice.mapper;

import com.vietsherlock.libraryservice.server.models.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    //Mapping book_client_gen Model to book_server_gen Model
    Book bookClientToBookServer(com.vietsherlock.libraryservice.restclient.model.Book book);

}
