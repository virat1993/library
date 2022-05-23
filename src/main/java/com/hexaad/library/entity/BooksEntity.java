package com.hexaad.library.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "books")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BooksEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "name")
    private String name ;

    @Column(name = "author")
    private String author ;

    @Column(name = "publication")
    private String publication ;

    @Column(name = "year_of_publication")
    private String year_of_publication;

    @Column(name = "isbn_no")
    private String isbn_no ;

    @Column(name = "quantity")
    private int quantity;

    @OneToMany(mappedBy = "booksEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<BookBorrowEntity> bookBorrowEntities;
}
