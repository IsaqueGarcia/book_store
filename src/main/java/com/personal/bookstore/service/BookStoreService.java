package com.personal.bookstore.service;

import com.personal.bookstore.dto.BookDTO;

import java.util.Optional;

public interface BookStoreService {

    String register(BookDTO request);
    Optional<BookDTO> consult(String title);

}
