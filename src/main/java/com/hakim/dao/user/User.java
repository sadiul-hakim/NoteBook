package com.hakim.dao.user;

/**
 *
 * @author Hakim
 */
public class User {
    private int id;
    private String fullname;
    private String email;
    private String password;
    private String uniqueid;

    public User() {
    }

    public User(int id, String fullname, String email, String password,String uniqueid) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.uniqueid=uniqueid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password + ", uniqueid=" + uniqueid + '}';
    }

   
    
    
}
