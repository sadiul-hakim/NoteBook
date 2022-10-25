package com.hakim.dao.note;

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
public class NoteRepoImp implements NoteRepository {

    private final Message errorMessage;

    public NoteRepoImp(Message errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean save(NoteDTO dto) {
        boolean isSaved = false;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "insert into notes(uid,title,description) value(?,?,?)";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, dto.getUid());
                statement.setString(2, dto.getTitle());
                statement.setString(3, dto.getDescription());

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
    public boolean update(NoteDTO dto,int id) {
        boolean isSaved = false;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "update notes set title=?,description=? where id=?";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, dto.getTitle());
                statement.setString(2, dto.getDescription());
                statement.setInt(3, id);

                statement.execute();
                isSaved = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Update Note.Please Try Again!");
        }

        return isSaved;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "delete from notes where id=?";

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
