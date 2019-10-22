package com.open.usermodule.service.room.user;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

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
@Dao
public interface UserDAO {

    @Insert
    void insert(User user);

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAll();

}
