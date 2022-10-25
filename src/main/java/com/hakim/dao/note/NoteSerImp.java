package com.hakim.dao.note;

import com.hakim.entities.Message;

/**
 *
 * @author Hakim
 */
public class NoteSerImp implements NoteService {
    private final NoteRepoImp repository;
    private final Message errorMessage;

    public NoteSerImp(NoteRepoImp repository, Message errorMessage) {
        this.repository = repository;
        this.errorMessage = errorMessage;
    }
    
    

    @Override
    public boolean saveNote(NoteDTO dto) {
        return repository.save(dto);
    }

    @Override
    public boolean updateNote(NoteDTO dto,int id) {
        return repository.update(dto, id);
    }

    @Override
    public boolean deleteNote(int id) {
        return repository.delete(id);
    }
    
}
