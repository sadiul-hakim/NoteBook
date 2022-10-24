package com.hakim.dao.user;

import jakarta.validation.constraints.NotEmpty;

/**
 *
 * @author Hakim
 */
public class LoginDTO {
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
