package com.hexaad.library.dto;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BooksDTO {

    private Integer id;

    private String name ;

    private String author ;

    private String publication ;

    private String year_of_publication;

    private String isbn_no ;

    private int quantity ;
}
