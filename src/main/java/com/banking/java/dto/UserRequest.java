package com.banking.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
}
