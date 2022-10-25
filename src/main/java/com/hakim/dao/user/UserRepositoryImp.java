package com.hakim.dao.user;

import com.hakim.db.ConnectionProvider;
import com.hakim.entities.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class UserRepositoryImp implements UserRepository {

    private final Message errorMessage;

    public UserRepositoryImp(Message errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean save(UserDTO dto) {
        boolean isSaved = false;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "insert into users(fullname,email,password,uniqueid) value(?,?,?,?)";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, dto.getFullname());
                statement.setString(2, dto.getEmail());
                statement.setString(3, dto.getPassword());
                statement.setString(4, dto.getUniqueId());

                statement.execute();
                isSaved = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Register User.Please Try Again!");
        }

        return isSaved;
    }

    @Override
    public Optional<User> login(LoginDTO dto) {
        Optional<User> user = Optional.ofNullable(null);
        ResultSet set = null;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "select * from users where email=? and password=?";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, dto.getEmail());
                statement.setString(2, dto.getPassword());

                set = statement.executeQuery();

                if (set.next()) {
                    int id = set.getInt("id");
                    String email = set.getString("email");
                    String fullname = set.getString("fullname");
                    String password = set.getString("password");
                    String uniqueId = set.getString("uniqueid");

                    user = Optional.of(new User(id, fullname, email, password, uniqueId));

                } else {
                    errorMessage.clear();
                    errorMessage.setMessage("Invalid Creadentials.");
                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not Login User.Please Try Again!");
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return user;
    }

    @Override
    public Optional<User> getUser(String email) {
        Optional<User> user = Optional.ofNullable(null);
        ResultSet set = null;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "select * from users where email=?";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, email);

                set = statement.executeQuery();

                if (set.next()) {
                    int id = set.getInt("id");
                    String em = set.getString("email");
                    String fullname = set.getString("fullname");
                    String password = set.getString("password");
                    String uniqueId = set.getString("uniqueid");

                    user = Optional.of(new User(id, fullname, em, password, uniqueId));

                } else {
                    errorMessage.clear();
                    errorMessage.setMessage("User not available");
                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not get User.Please Try Again!");
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return user;
    }

    @Override
    public Optional<User> getUserById(int id) {
        Optional<User> user = Optional.ofNullable(null);
        ResultSet set = null;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "select * from users where id=?";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);

                set = statement.executeQuery();

                if (set.next()) {
                    int uid = set.getInt("id");
                    String em = set.getString("email");
                    String fullname = set.getString("fullname");
                    String password = set.getString("password");
                    String uniqueId = set.getString("uniqueid");

                    user = Optional.of(new User(uid, fullname, em, password, uniqueId));

                } else {
                    errorMessage.clear();
                    errorMessage.setMessage("User not available");
                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not get User.Please Try Again!");
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return user;
    }
    
    @Override
    public Optional<User> getUserByUniqueId(String id) {
        Optional<User> user = Optional.ofNullable(null);
        ResultSet set = null;
        try ( Connection connection = ConnectionProvider.getConnection()) {
            String query = "select * from users where uniqueid=?";

            try ( PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);

                set = statement.executeQuery();

                if (set.next()) {
                    int uid = set.getInt("id");
                    String em = set.getString("email");
                    String fullname = set.getString("fullname");
                    String password = set.getString("password");
                    String uniqueId = set.getString("uniqueid");

                    user = Optional.of(new User(uid, fullname, em, password, uniqueId));

                } else {
                    errorMessage.clear();
                    errorMessage.setMessage("User not available");
                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage.clear();
            errorMessage.setMessage("Could not get User.Please Try Again!");
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepositoryImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return user;
    }

}
