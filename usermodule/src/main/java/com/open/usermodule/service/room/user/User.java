package com.open.usermodule.service.room.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-10-18.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
@Entity(tableName = "user_table")
public class User {

    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "mobile")
    public String mobile;

    @ColumnInfo(name = "pwd")
    public String pwd;

    @ColumnInfo(name = "createDate")
    public String createDate;

    @ColumnInfo(name = "updateDate")
    public String updateDate;
}
