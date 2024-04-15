package com.example.demo.services;

import com.example.demo.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    Book getBook(Long id);

    Book addBook(Book book);

    Book updateBook(Book book);

    Boolean deleteBook(Long id);
}
