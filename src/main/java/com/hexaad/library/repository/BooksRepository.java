package com.hexaad.library.repository;

import com.hexaad.library.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {

    Optional<BooksEntity> findByIdAndQuantityGreaterThan(int id, int quantity);
}
