package com.example.GEEKUP_test.Service.Impl;

import com.example.GEEKUP_test.DTO.UserDTO;
import com.example.GEEKUP_test.Exception.MyException;
import com.example.GEEKUP_test.Mapper.UserMapper;
import com.example.GEEKUP_test.Repository.UserRepository;
import com.example.GEEKUP_test.Service.Interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.Model.User;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Response createUser(UserDTO user) {
        Response response = new Response();
        try {
            User newUser = userMapper.toUser(user);
            userRepository.save(newUser);
            response.setMessage("User created successfully");
            response.setStatusCode(200);
            response.setUser(user);
        } catch (Exception e) {
            response.setMessage("User created failed");
            response.setStatusCode(400);
        }
        return response;
    }

    @Override
    public Response updateUser(UserDTO user) {
        Response response = new Response();
        try {
            User newUser = userMapper.toUser(user);
            userRepository.save(newUser);
            response.setMessage("User updated successfully");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setMessage("User updated failed");
            response.setStatusCode(400);
        }
        return response;
    }

    @Override
    public Response deleteUser(String id) {
        Response response = new Response();
        try {
            var user = userRepository.findById(Long.parseLong(id)).orElseThrow(() -> new MyException("User not found"));
            userRepository.delete(user);
            response.setMessage("User deleted successfully");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setMessage("User deleted failed");
            response.setStatusCode(400);
        }
        return response;
    }

    @Override
    public Response getUserById(String id) {
        Response response = new Response();
        try {
            var user = userRepository.findById(Long.parseLong(id)).orElseThrow(() -> new MyException("User not found"));
            response.setUser(userMapper.toUserDTO(user));
            response.setMessage("User retrieved successfully");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setMessage("User retrieved failed");
            response.setStatusCode(400);
        }
        return response;
    }

    @Override
    public Response getAllUsers() {
        Response response = new Response();
        try {
            response.setUserList(userRepository.findAll().stream().map(userMapper::toUserDTO).toList());
            response.setMessage("Users retrieved successfully");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setMessage("Users retrieved failed");
            response.setStatusCode(400);
        }
        return response;
    }

}
