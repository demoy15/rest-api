package com.demoy.bookstore.controllers;


import com.demoy.bookstore.model.Books;
import com.demoy.bookstore.service.interfaces.BooksService;
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
@RequestMapping("api/v1/books/")
public class BooksController {

    @Autowired
    BooksService booksService;

    @ApiOperation(value = "Get book by id")
   @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Books> getBook(@PathVariable(value = "id") Long bookId){
        if(bookId==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Books books = this.booksService.getById(bookId);

        if(books==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books,HttpStatus.OK);

    }

    @ApiOperation(value = "Book creation")
    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Books> saveBook(@RequestBody @Valid Books book){
        HttpHeaders headers = new HttpHeaders();

        if(book==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.booksService.save(book);

        return new ResponseEntity<>(book,headers,HttpStatus.CREATED);
    }

    @ApiOperation(value = "Change book")
    @PatchMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Books> updateBook(@RequestBody @Valid Books book){
        HttpHeaders httpHeaders = new HttpHeaders();

        if(book==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.booksService.save(book);

        return new ResponseEntity<>(book,httpHeaders,HttpStatus.OK);
    }

    @ApiOperation(value = "Delete book by id")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Books> deleteBook(@PathVariable(value = "id") Long id){
        Books book = this.booksService.getById(id);

        if(book==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.booksService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Get all books")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Books>> getAllBooks() {
        List<Books> booksList = this.booksService.getAll();
        if (booksList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(booksList, HttpStatus.OK);
    }


}
