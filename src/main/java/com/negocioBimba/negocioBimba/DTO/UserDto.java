package com.negocioBimba.negocioBimba.DTO;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    Integer userId;
    String name;
    String lastName;
    String password;
    String cellPhoneNumber;
    String email;
    String role;
}
