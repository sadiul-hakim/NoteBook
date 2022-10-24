package com.hakim.dao.user;

import com.hakim.entities.Message;
import com.hakim.entities.PasswordEncryptor;
import java.util.Optional;

/**
 *
 * @author Hakim
 */
public class UserServiceImp implements UserService {
    private final UserRepository repository;
    private final Message errorMessage;
    private final PasswordEncryptor passwordEncryptor;

    public UserServiceImp(UserRepository repository, Message errorMessage, PasswordEncryptor passwordEncryptor) {
        this.repository = repository;
        this.errorMessage = errorMessage;
        this.passwordEncryptor = passwordEncryptor;
    }

   

    @Override
    public boolean userRegister(UserDTO dto) {
        String password=dto.getPassword();
        password=passwordEncryptor.encrypt(password);
        
        dto.setPassword(password);
        
        Optional<User> user=repository.getUser(dto.getEmail());
        
        if(user.isPresent()){
            errorMessage.clear();
            errorMessage.setMessage("User already exists!Please Login!");
            return false;
        }
        
        
        return repository.save(dto);
    }

    @Override
    public Optional<User> userLogin(LoginDTO dto) {
        String password=dto.getPassword();
        password=passwordEncryptor.encrypt(password);
        
        dto.setPassword(password);
        
        return repository.login(dto);
    }
    
    
}
