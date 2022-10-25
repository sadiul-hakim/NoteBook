package com.hakim.dao.note;

/**
 *
 * @author Hakim
 */
public interface NoteRepository {
    boolean save(NoteDTO dto);
    boolean update(NoteDTO dto,int id);
    boolean delete(int id);
}
