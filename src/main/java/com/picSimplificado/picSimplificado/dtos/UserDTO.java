package com.picSimplificado.picSimplificado.dtos;

import com.picSimplificado.picSimplificado.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String cpf, BigDecimal balance, String email, String password, UserType userType) {

}
