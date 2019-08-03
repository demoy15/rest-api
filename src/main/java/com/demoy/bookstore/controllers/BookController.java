package com.demoy.bookstore.controllers;


import com.demoy.bookstore.model.Book;
import com.demoy.bookstore.service.interfaces.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/book/")
public class BookController {

    @Autowired
    BookService bookService;

    /** Gets object "Book" by id */
    @ApiOperation(value = "Gets book by id")
    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable(value = "id") Long bookId){

        if(bookId==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Book book = bookService.getById(bookId);

        if(book ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(book,HttpStatus.OK);

    }

    /** Creation object "Book" */
    @ApiOperation(value = "Book creation")
    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> saveBook(@RequestBody @Valid Book book){

        HttpHeaders headers = new HttpHeaders();

        if(book==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.bookService.save(book);

        return new ResponseEntity<>(book,headers,HttpStatus.CREATED);
    }

    /** Change object "Book" */
    @ApiOperation(value = "Change book")
    @PatchMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> updateBook(@RequestBody @Valid Book book){

        HttpHeaders httpHeaders = new HttpHeaders();

        if(book==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.bookService.save(book);

        return new ResponseEntity<>(book,httpHeaders,HttpStatus.OK);
    }

    /** Delete object "Book" by id */
    @ApiOperation(value = "Delete book by id")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") Long id){

        Book book = this.bookService.getById(id);

        if(book==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.bookService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /** Gets all objects "Book" */
    @ApiOperation(value = "Get all books")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Book>> getAllBooks() {

        List<Book> bookList = this.bookService.getAll();

        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

}
