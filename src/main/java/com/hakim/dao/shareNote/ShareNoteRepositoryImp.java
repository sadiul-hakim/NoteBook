package com.hakim.dao.shareNote;

import com.hakim.dao.user.UserRepositoryImp;
import com.hakim.db.ConnectionProvider;
import com.hakim.entities.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class ShareNoteRepositoryImp implements ShareNoteRepository {
    private final Message errorMessage;

    public ShareNoteRepositoryImp(Message errorMessage) {
        this.errorMessage = errorMessage;
    }    
    
    @Override
    public boolean share(ShareNoteDTO dto) {
        boolean isSaved = false;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "insert into sharednotes(nid,aid,uniqueid,title,description,aname) value(?,?,?,?,?,?)";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, dto.getNid());
                statement.setString(2, dto.getAid());
                statement.setString(3, dto.getUniqueid());
                statement.setString(4, dto.getTitle());
                statement.setString(5, dto.getDescription());
                statement.setString(6, dto.getAname());

                statement.execute();
                isSaved = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Save Note.Please Try Again!");
        }

        return isSaved;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "delete from sharednotes where id=?";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
               
                statement.setInt(1, id);

                statement.execute();
                isDeleted = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Delete Note.Please Try Again!");
        }

        return isDeleted;
    }
}
