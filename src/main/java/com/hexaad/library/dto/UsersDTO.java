package com.hexaad.library.dto;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UsersDTO {

    private Integer id;

    private String address;

    private String libraryCardNumber;

    private String name;
}
