package com.hakim.dao.user;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface UserService {
    boolean userRegister(UserDTO dto);
    Optional<User> userLogin(LoginDTO dto);
   
}
