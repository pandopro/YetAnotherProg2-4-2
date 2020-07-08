package project.service;


import project.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    Boolean remove(long id);

    User getUser(long id);

    Boolean edit(long id, User user);


}
