package project.service;


import project.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    boolean remove(long id);

    User getUser(long id);

    User findByLogin(String login);

    boolean edit(long id, User user);

    boolean demo();


}
