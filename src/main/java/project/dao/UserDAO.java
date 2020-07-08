package project.dao;


import project.Model.User;

import java.util.List;

public interface UserDAO {
    void add(User var1);

    List<User> listUsers();

    Boolean remove(long id);

    Boolean edit(long id, User user);

    User getUser(long id);

}
