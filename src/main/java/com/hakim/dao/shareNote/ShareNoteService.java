package com.hakim.dao.shareNote;

/**
 *
 * @author Hakim
 */
public interface ShareNoteService {
    boolean share(ShareNoteDTO dto);
    boolean delete(int id);
}
