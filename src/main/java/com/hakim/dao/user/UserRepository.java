package com.hakim.dao.user;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public interface UserRepository {
    boolean save(UserDTO dto);
    Optional<User> login(LoginDTO dto);
    Optional<User> getUser(String email);
    Optional<User> getUserById(int id);
    Optional<User> getUserByUniqueId(String id);
}
