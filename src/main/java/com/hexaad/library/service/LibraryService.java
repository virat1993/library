package com.hexaad.library.service;

import com.hexaad.library.dto.BooksDTO;
import com.hexaad.library.dto.BorrowDTO;
import com.hexaad.library.entity.BookBorrowEntity;
import com.hexaad.library.entity.BooksEntity;
import com.hexaad.library.entity.UsersEntity;
import com.hexaad.library.repository.BooksRepository;
import com.hexaad.library.repository.BorrowBookRepository;
import com.hexaad.library.repository.UsersRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    @Autowired
    BooksRepository booksRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BorrowBookRepository borrowBookRepository;

    public List<BooksEntity> getListOfAvailableBooks() {
        Optional<List<BooksEntity>> data = Optional.ofNullable(booksRepository.findAll());
        return data.get().stream()
                .filter(booksEntity -> booksEntity.getQuantity() > 0).collect(Collectors.toList());
    }

    public String addBook(BooksDTO booksDTO) {
        BooksEntity booksEntity = BooksEntity.builder()
                .name(booksDTO.getName())
                .author(booksDTO.getAuthor())
                .publication(booksDTO.getPublication())
                .quantity(booksDTO.getQuantity())
                .year_of_publication(booksDTO.getYear_of_publication())
                .isbn_no(booksDTO.getIsbn_no())
                .build();
        booksRepository.save(booksEntity);
        return "book added successfully";
    }

    @SneakyThrows
    public String borrowBook(BorrowDTO borrowDTO) {
        Optional<BooksEntity> booksEntity = booksRepository.findByIdAndQuantityGreaterThan(borrowDTO.getBookId(), 0);
        Optional<UsersEntity> usersEntity = usersRepository.findById(borrowDTO.getUserId());
        Optional<List<BookBorrowEntity>> bookBorrowEntity;
        if (booksEntity.isPresent() && usersEntity.isPresent()) {
            bookBorrowEntity = borrowBookRepository.findByUserIdAndIsReturnedEquals(usersEntity.get(), 1);
        } else {
            throw new Exception("Book or user not found");
        }
        if (bookBorrowEntity.isPresent() && bookBorrowEntity.get().size() >= 2) {
            throw new Exception("User reached borrowing limit");
        }
        int quantity = booksEntity.get().getQuantity();
        booksEntity.get().setQuantity(quantity - 1);

        BookBorrowEntity entity = BookBorrowEntity.builder()
                .booksEntity(booksEntity.get())
                .libraryCardNumber("123")
                .userId(usersEntity.get())
                .isReturned(1)
                .build();
        borrowBookRepository.save(entity);

        return "Book borrowed " + booksEntity.get().getName();
    }

    public String returnBook(List<BorrowDTO> borrowDTOS) {
        // List<BookBorrowEntity> bookBorrowEntities ;
        borrowDTOS.stream().forEach(borrowDTO -> {
            List<BookBorrowEntity> bookBorrowEntities;
            UsersEntity usersEntity = usersRepository.findById(borrowDTO.getUserId()).get();
            Optional<BooksEntity> booksEntity = booksRepository.findById(borrowDTO.getBookId());
            bookBorrowEntities = borrowBookRepository.findByUserIdAndBooksEntity(usersEntity, booksEntity.get()).get();

            bookBorrowEntities.forEach(list -> {
                list.setIsReturned(0);
                int quantity = list.getBooksEntity().getQuantity();
                list.getBooksEntity().setQuantity(quantity + 1);
            });
            borrowBookRepository.saveAll(bookBorrowEntities);
        });
        return "returned successful";
    }
}