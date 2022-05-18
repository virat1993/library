package com.hexaad.library.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Table
@Entity(name = "borrow")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BookBorrowEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity userId;

    @Column(name = "library_card_number")
    private String libraryCardNumber;

    @Column(name = "is_returned")
    private int isReturned;


    @ManyToOne( cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    @JoinColumn( name = "book_id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private BooksEntity booksEntity;
}
