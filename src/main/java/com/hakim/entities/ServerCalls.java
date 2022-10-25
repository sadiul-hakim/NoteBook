package com.hakim.entities;

import com.hakim.dao.note.Note;
import com.hakim.dao.shareNote.ShareNote;
import com.hakim.dao.user.User;
import com.hakim.dao.user.UserRepositoryImp;
import com.hakim.db.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class ServerCalls {

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        ResultSet set = null;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "select * from users";

            try ( Statement statement = connection.createStatement()) {

                set = statement.executeQuery(query);

                while (set.next()) {

                    users.add(
                            new User(
                                    set.getInt("id"),
                                    set.getString("email"),
                                    set.getString("fullname"),
                                    set.getString("password"),
                                    set.getString("uniqueid")
                            )
                    );

                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return users;
    }
    
    public static List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        ResultSet set = null;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "select * from notes";

            try ( Statement statement = connection.createStatement()) {

                set = statement.executeQuery(query);

                while (set.next()) {

                    notes.add(
                            new Note(
                                    set.getInt("id"),
                                    set.getInt("uid"),
                                    set.getString("title"),
                                    set.getString("description"),
                                    set.getTimestamp("date")
                            )
                    );

                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return notes;
    }
    public static List<Note> getAllNotesOfAUser(int uid) {
        List<Note> notes = new ArrayList<>();
        ResultSet set = null;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "select * from notes where uid=?";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, uid);
                set = statement.executeQuery();

                while (set.next()) {

                    notes.add(
                            new Note(
                                    set.getInt("id"),
                                    set.getInt("uid"),
                                    set.getString("title"),
                                    set.getString("description"),
                                    set.getTimestamp("date")
                            )
                    );

                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return notes;
    }
    public static List<ShareNote> getAllSharedNotesOfAUser(String uid) {
        List<ShareNote> notes = new ArrayList<>();
        ResultSet set = null;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "select * from sharednotes where uniqueid=?";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, uid);
                set = statement.executeQuery();

                while (set.next()) {

                    notes.add(
                            new ShareNote(
                                    set.getInt("id"),
                                    set.getInt("nid"),
                                    set.getString("aid"),
                                    set.getString("uniqueid"),
                                    set.getString("aname"),
                                    set.getString("title"),
                                    set.getString("description"),
                                    set.getTimestamp("date")
                            )
                    );

                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return notes;
    }
    
    public static Optional<Note> getANote(int id) {
        Optional<Note> note = Optional.ofNullable(null);
        ResultSet set = null;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "select * from notes where id=?";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);

                set = statement.executeQuery();

                if (set.next()) {
                    int nid = set.getInt("id");
                    int uid = set.getInt("uid");
                    String title = set.getString("title");
                    String description=set.getString("description");
                    Timestamp date=set.getTimestamp("date");

                    note = Optional.of(new Note(nid, uid, title, description, date));

                } 

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return note;
    }
}
