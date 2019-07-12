package dao;

import entity.User;

public interface UserDao {
    boolean isExist(String username);

    User findUserByUsername(String username);

}
