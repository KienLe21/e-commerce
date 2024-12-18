package com.example.GEEKUP_test.Service.Interf;

import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.DTO.UserDTO;
import com.example.GEEKUP_test.Model.User;

public interface UserService {
    Response createUser(UserDTO user);
    Response updateUser(UserDTO user);
    Response deleteUser(String id);
    Response getUserById(String id);
    Response getAllUsers();
}
