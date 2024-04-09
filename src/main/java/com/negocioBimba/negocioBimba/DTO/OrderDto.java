package com.negocioBimba.negocioBimba.DTO;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    Integer id;
    Integer client;
    Boolean state;
    Date date;
    Set<Integer> products;
}
