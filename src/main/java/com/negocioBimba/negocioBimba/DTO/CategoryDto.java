package com.negocioBimba.negocioBimba.DTO;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Integer categoryId;

    private String name;

    private String supCategory;
}
