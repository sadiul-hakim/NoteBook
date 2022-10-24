package com.hakim.dao.user;

import jakarta.validation.constraints.NotEmpty;

/**
 *
 * @author Hakim
 */
public class UserDTO {
    @NotEmpty
    private String fullname;
    
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String password;
    
    @NotEmpty
    private String uniqueId;
    
    

    public UserDTO() {
    }

    public UserDTO(String fullname, String email, String password,String uniqueId) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.uniqueId=uniqueId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUniqueId() {
        return uniqueId;
    }
    
    
    
}
