package com.erich.codeando.controller.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistroRequest {

    private String nombre;
    private String apellido;
    private String email;
    private String password;
}
