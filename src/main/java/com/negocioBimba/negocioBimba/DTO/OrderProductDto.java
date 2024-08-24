package com.negocioBimba.negocioBimba.DTO;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderProductDto {
    private Integer product;
    private Integer quantity;
}
