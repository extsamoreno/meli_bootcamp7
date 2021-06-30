package com.example.mongodbexample.controller;

import com.example.mongodbexample.domain.Book;
import com.example.mongodbexample.service.BookService;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mongoexample")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books")
    public List<Book> getAllBooks(@Nullable @RequestParam String author) {
        System.out.println(author);
        return author == null ? bookService.findAllBooks() : bookService.findBooksByAuthor(author);
    }


    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
}
