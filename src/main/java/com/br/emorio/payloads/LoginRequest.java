package com.br.emorio.payloads;

import javax.validation.constraints.NotBlank;


public class LoginRequest {

    @NotBlank(message = "Preencha o campo de email")
    private String username;
    @NotBlank(message = "Preecha o campo da senha")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
