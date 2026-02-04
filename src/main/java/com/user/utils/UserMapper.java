package com.user.utils;

import com.user.data.models.UserInfo;
import com.user.dtos.request.UserRequest;
import com.user.dtos.response.UserResponse;
import org.apache.catalina.User;


public class UserMapper {

    public static UserInfo map(UserRequest request) {
        UserInfo user = new UserInfo();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        return user;
    }

    public static UserResponse map(UserInfo user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(user.getUserName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        return userResponse;
    }

}
