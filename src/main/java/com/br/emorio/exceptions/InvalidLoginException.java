package com.br.emorio.exceptions;


public class InvalidLoginException {
    private String username;
    private String password;

    public InvalidLoginException() {
        this.username = "Login inválido";
        this.password = "Senha inválida";
    }

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
