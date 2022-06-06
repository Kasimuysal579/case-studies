package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId){
        return bookRepository.findById(bookId).get();
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBookById(Long bookId){
        bookRepository.deleteById(bookId);
    }
}
