package com.open.usermodule.service.room.user;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-10-22.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class UserRepository {
    UserDAO userDAO;
    public LiveData<List<User>> users;

    public UserRepository(UserDAO userDAO) {
        this.userDAO = userDAO;
        users = userDAO.getAll();
    }

    @WorkerThread
    public void insert(User user) {
        userDAO.insert(user);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }
}
