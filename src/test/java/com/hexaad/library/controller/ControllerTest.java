package com.hexaad.library.controller;

import com.hexaad.library.dto.BooksDTO;
import com.hexaad.library.dto.BorrowDTO;
import com.hexaad.library.dto.UsersDTO;
import com.hexaad.library.entity.BookBorrowEntity;
import com.hexaad.library.entity.BooksEntity;
import com.hexaad.library.entity.UsersEntity;
import com.hexaad.library.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

//@SpringBootTest
class ControllerTest {

    @Mock
    LibraryService libraryService;

    @InjectMocks
    Controller controller;

    BooksEntity booksEntity;
    UsersEntity usersEntity;
    BookBorrowEntity bookBorrowEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        booksEntity = new BooksEntity();
        booksEntity.setId(1);
        booksEntity.setName("test book");
        booksEntity.setAuthor("author");
        booksEntity.setPublication("test publication");
        booksEntity.setYear_of_publication("2022");
        booksEntity.setIsbn_no("number");
        booksEntity.setQuantity(1);

        usersEntity = new UsersEntity();
        usersEntity.setId(1);
        usersEntity.setName("aman");
        usersEntity.setAddress("dubai");
        usersEntity.setLibrary_card_number("number");
        usersEntity.setIs_active(1);

    }

    @Test
    void addBook() {
        BooksDTO booksDTO = new BooksDTO();
        booksDTO.setName("Test Name");
        booksDTO.setAuthor("Test Author");
        booksDTO.setPublication("Test Publisher");
        booksDTO.setYear_of_publication("2022");
        booksDTO.setIsbn_no("Test123");
        booksDTO.setQuantity(10);


        when(libraryService.addBook(booksDTO)).thenReturn("book added successfully");
        ResponseEntity<String> addBook = controller.addBook(booksDTO);
        String msg = addBook.getBody();
        assertNotNull(addBook);
        assertEquals(addBook.getStatusCodeValue(),200);
        assertEquals("book added successfully",msg);
    }

    @Test
    void addUser(){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setAddress("Abu Dubai");
        usersDTO.setLibraryCardNumber("L90");
        usersDTO.setName("TestUser");


        when(libraryService.addUser(usersDTO)).thenReturn("user added");
        ResponseEntity<String> addUser = controller.addUser(usersDTO);
        String msg = addUser.getBody();
        assertNotNull(addUser);
        assertEquals(addUser.getStatusCodeValue(),200);
        assertEquals("user added",msg);
    }

    @Test
    void getListOfAvailableBooks() {
        BooksDTO booksDTO = new BooksDTO();
        booksDTO.setName("Test Name");
        booksDTO.setAuthor("Test Author");
        booksDTO.setPublication("Test Publisher");
        booksDTO.setYear_of_publication("2022");
        booksDTO.setIsbn_no("Test123");
        booksDTO.setQuantity(10);

        List<BooksDTO> booksEntities = new ArrayList<>();
        booksEntities.add(booksDTO);

        when(libraryService.getListOfAvailableBooks()).thenReturn(booksEntities);

        ResponseEntity<List<BooksDTO>> getListOfAvailableBooks = controller.getListOfAvailableBooks();
        List<BooksDTO> outputlist= getListOfAvailableBooks.getBody();
        assertEquals(booksEntities, outputlist);
    }

    @Test
    void borrowBook() {

        BorrowDTO borrowDTO = new BorrowDTO();
        borrowDTO.setUserId(1);
        borrowDTO.setBookId(1);

        when(libraryService.borrowBook(borrowDTO)).thenReturn("Book borrowed test book");

        ResponseEntity<?> borrowBook = controller.borrowBook(borrowDTO);
        String msg = (String) borrowBook .getBody();
        assertEquals(borrowBook.getStatusCodeValue(),200);
        assertEquals("Book borrowed test book",msg);
    }

    @Test
    void returnBook() {
        BorrowDTO borrowDTO = new BorrowDTO();
        borrowDTO.setUserId(1);
        borrowDTO.setBookId(1);

        List<BorrowDTO> borrowDTOS = new ArrayList<>();
        borrowDTOS.add(borrowDTO);
        when(libraryService.returnBook(borrowDTOS)).thenReturn("returned successful");

        ResponseEntity<?> borrowBook = controller.returnBook(borrowDTOS);
        String msg = (String) borrowBook .getBody();
        assertEquals(borrowBook.getStatusCodeValue(),200);
        assertEquals("returned successful",msg);
    }
}