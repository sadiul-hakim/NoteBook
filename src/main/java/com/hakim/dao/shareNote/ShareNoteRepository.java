package com.hakim.dao.shareNote;

/**
 *
 * @author Hakim
 */
public interface ShareNoteRepository {

    boolean share(ShareNoteDTO dto);

    boolean delete(int id);
}
