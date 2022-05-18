package com.hexaad.library.controller;

import com.hexaad.library.dto.BooksDTO;
import com.hexaad.library.dto.BorrowDTO;
import com.hexaad.library.entity.BooksEntity;
import com.hexaad.library.service.LibraryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    LibraryService libraryService;

    @GetMapping("/getBooks")
    public List<BooksEntity> getListOfAvailableBooks(){
        return  libraryService.getListOfAvailableBooks();
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody BooksDTO booksDTO){
        return libraryService.addBook(booksDTO);
    }

    @PostMapping("/borrowBook")
    public String borrowBook(@RequestBody BorrowDTO borrowDTO){
        return libraryService.borrowBook(borrowDTO);
    }

    @PostMapping("/returnBook")
    public String returnBook(@RequestBody List<BorrowDTO> borrowDTOS){
        return libraryService.returnBook(borrowDTOS);
    }

}
