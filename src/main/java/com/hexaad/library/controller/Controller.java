package com.hexaad.library.controller;

import com.hexaad.library.dto.BooksDTO;
import com.hexaad.library.dto.BorrowDTO;
import com.hexaad.library.dto.UsersDTO;
import com.hexaad.library.entity.BooksEntity;
import com.hexaad.library.service.LibraryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
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
    public ResponseEntity<List<BooksDTO>> getListOfAvailableBooks(){
        return ResponseEntity.ok(libraryService.getListOfAvailableBooks());
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody BooksDTO booksDTO){
        return ResponseEntity.ok(libraryService.addBook(booksDTO));
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UsersDTO usersDTO){
        return ResponseEntity.ok(libraryService.addUser(usersDTO));
    }

    @PostMapping("/borrowBook")
    public ResponseEntity<String> borrowBook(@RequestBody BorrowDTO borrowDTO){
        return ResponseEntity.ok(libraryService.borrowBook(borrowDTO));
    }

    @PostMapping("/returnBook")
    public ResponseEntity<String> returnBook(@RequestBody List<BorrowDTO> borrowDTOS){
        return ResponseEntity.ok(libraryService.returnBook(borrowDTOS));
    }

}
