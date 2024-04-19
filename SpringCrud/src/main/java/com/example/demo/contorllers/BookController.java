package com.example.demo.contorllers;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @GetMapping("/get/error")
    public String error(){
        int a = 5;
        if(a != 5){
            return "not five";
        } else {
            throw new RuntimeException("Error For Tracing");
        }
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete")
    public Boolean deleteBook(@RequestParam Long id){
        return  bookService.deleteBook(id);
    }
}
