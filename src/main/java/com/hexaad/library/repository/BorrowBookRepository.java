package com.hexaad.library.repository;

import com.hexaad.library.entity.BookBorrowEntity;
import com.hexaad.library.entity.BooksEntity;
import com.hexaad.library.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BorrowBookRepository extends JpaRepository<BookBorrowEntity, Integer> {

    Optional<List<BookBorrowEntity>> findByUserIdAndBooksEntity(UsersEntity user,  BooksEntity bookId);

    Optional<List<BookBorrowEntity>> findByUserIdAndIsReturnedEquals(UsersEntity users, int i);
}
