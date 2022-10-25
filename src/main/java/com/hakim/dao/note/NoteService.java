package com.hakim.dao.note;

/**
 *
 * @author Hakim
 */
public interface NoteService {
    boolean saveNote(NoteDTO dto);
    boolean updateNote(NoteDTO dto,int id);
    boolean deleteNote(int id);
}
