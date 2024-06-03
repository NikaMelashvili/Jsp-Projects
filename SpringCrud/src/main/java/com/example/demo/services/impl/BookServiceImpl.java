package com.example.demo.services.impl;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Override
    public Book getBook(Long id) {
        Book book = new Book();
        book.setId(id);
        book.setName("sagd");
        book.setAuthor("kaxetelidze");
        return book;
    }

    @Override
    public Book addBook(Book book) {
        book.setName("meore wigni");
        book.setAuthor("xinkali");
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        book.setAuthor("updated author");
        return book;
    }

    @Override
    public Boolean deleteBook(Long id) {
        Book book = getBook(id);
        book.setId(null);
        return true;
    }
}
