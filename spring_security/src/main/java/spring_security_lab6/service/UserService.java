package spring_security_lab6.service;


import spring_security_lab6.dto.UserDto;
import spring_security_lab6.dto.UserDtoResponse;
import spring_security_lab6.entity.LoginRequest;
import spring_security_lab6.entity.LoginResponse;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDtoResponse save(UserDto user);
    void remove(Long id);
    LoginResponse login(LoginRequest loginRequest);
}
