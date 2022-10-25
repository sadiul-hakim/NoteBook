package com.hakim.dao.shareNote;

import com.hakim.dao.user.User;
import com.hakim.dao.user.UserRepository;
import com.hakim.entities.Message;
import java.util.Optional;

/**
 *
 * @author Hakim
 */
public class ShareNoteServiceImp implements ShareNoteService {
     private final Message errorMessage;
     private final ShareNoteRepository repository;
     private final UserRepository userRepository;

    public ShareNoteServiceImp(Message errorMessage, ShareNoteRepository repository, UserRepository userRepository) {
        this.errorMessage = errorMessage;
        this.repository = repository;
        this.userRepository = userRepository;
    }

    

    @Override
    public boolean share(ShareNoteDTO dto) {
        Optional<User> user=userRepository.getUserByUniqueId(dto.getUniqueid());
        if(!user.isPresent()){
            errorMessage.clear();
            errorMessage.setMessage("There is no your with this id.");
            return false;
        }
        
        return repository.share(dto);
    }
    
      @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }
    
}
