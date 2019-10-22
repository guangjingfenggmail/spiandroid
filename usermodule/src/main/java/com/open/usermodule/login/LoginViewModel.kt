package com.open.usermodule.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.open.usermodule.service.room.user.User
import com.open.usermodule.service.room.user.UserRepository
import com.open.usermodule.service.room.user.UserRoomDatabase
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-04.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 */
public class LoginViewModel(application: Application) : AndroidViewModel(application) {
    var mloginLiveData = MutableLiveData<LoginModel>()
    var mLoginRepertory = LoginRepertory()

    var userRepository: UserRepository? = null


    fun init() {
        userRepository = UserRepository(UserRoomDatabase.getDatabase(getApplication(), viewModelScope).userDao())
    }


    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository!!.insert(user)
    }

    fun delete(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository!!.delete(user)
    }

}
