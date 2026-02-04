package com.user.services;

import com.user.data.models.UserInfo;
import com.data.repository.CustomerRepository;
import com.user.dtos.request.UserRequest;
import com.user.dtos.response.UserResponse;
import com.user.exception.EmailExistException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.user.utils.UserMapper.map;

@NoArgsConstructor
@Service
public class RegisterUserImp implements RegisterUser {

    @Autowired
    private CustomerRepository userRepository;

    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        UserInfo userInfo = map(userRequest);
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new EmailExistException("Email Already Registered");
        }

        UserInfo foundUser = userRepository.save(userInfo);
        return map(foundUser);
    }
}
