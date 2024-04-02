package com.negocioBimba.negocioBimba.DTO;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {
    Integer clientId;
    String name;
    String contact;
    String email;
    String location;
}
