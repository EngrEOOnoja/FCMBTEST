package com.user.services;

import com.user.dtos.request.UserRequest;
import com.user.dtos.response.UserResponse;

public interface RegisterUser {
    UserResponse registerUser(UserRequest userRequest);

}


