package com.negocioBimba.negocioBimba.DTO;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private Float price;
    private Integer stock;
    private Integer category;
}
