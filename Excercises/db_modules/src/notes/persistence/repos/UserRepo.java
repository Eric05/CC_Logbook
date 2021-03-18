package notes.persistence.repos;

import notes.persistence.models.User;

import java.util.List;

public interface UserRepo {
    User getUserById(int id);

    List<User> getUsers();

    void registerUser(String name, String password);

    User getUser(String name, String hashedString);

    User getUser(String name);
}
