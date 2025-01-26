package com.personal.bookstore.service.impl;

import com.personal.bookstore.dto.BookDTO;
import com.personal.bookstore.repository.BookStoreRepository;
import com.personal.bookstore.service.BookStoreService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    BookStoreRepository repository;

    @Override
    public Integer register(BookDTO request) {
        BookDTO response = repository.save(request);
        return response.getId();
    }

    @Override
    public Optional<BookDTO> consult(Integer id, String... args) {

        Optional<BookDTO> book = Optional.empty();

        if(id == null && !StringUtils.isEmpty(args[0])){
            book = repository.findByTitle(args[0]);
        }else{
            book = repository.findById(id);
        }

        return book;
    }
}
