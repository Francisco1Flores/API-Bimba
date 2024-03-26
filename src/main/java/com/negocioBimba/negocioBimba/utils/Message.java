package com.negocioBimba.negocioBimba.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@Builder
public class Message implements Serializable {

    private String message;
    private Object object;
}
