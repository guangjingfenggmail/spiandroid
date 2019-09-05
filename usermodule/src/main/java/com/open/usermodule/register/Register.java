package com.open.usermodule.register;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2019-09-05.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Register implements Parcelable {

    public String userName;
    public String password;
    public String mobile;
    public String otpCode;

    protected Register(Parcel in) {
        userName = in.readString();
        password = in.readString();
        mobile = in.readString();
        otpCode = in.readString();
    }

    public static final Creator<Register> CREATOR = new Creator<Register>() {
        @Override
        public Register createFromParcel(Parcel in) {
            return new Register(in);
        }

        @Override
        public Register[] newArray(int size) {
            return new Register[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userName);
        dest.writeString(this.password);
        dest.writeString(this.mobile);
        dest.writeString(this.otpCode);
    }


}
