package com.hexaad.library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowDTO {

    private int userId;
    private int bookId;
}
