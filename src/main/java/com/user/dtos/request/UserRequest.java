package com.user.dtos.request;

import lombok.Data;

@Data
public class UserRequest {

    private String userName;
    private String email;
    private String password;
    private String phoneNumber;

}
