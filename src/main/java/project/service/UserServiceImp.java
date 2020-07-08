package project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.User;
import project.dao.UserDAO;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserDAO userDao;

    public UserServiceImp() {
    }

    @Transactional
    public void add(User user) {
        this.userDao.add(user);
    }


    public List<User> listUsers() {
        return this.userDao.listUsers();
    }


    @Transactional
    @Override
    public Boolean remove(long id) {
        return this.userDao.remove(id);
    }


    @Override
    public User getUser(long id) {
        return this.userDao.getUser(id);
    }

    @Transactional
    @Override
    public Boolean edit(long id, User user) {
        return this.userDao.edit(id, user);
    }
}