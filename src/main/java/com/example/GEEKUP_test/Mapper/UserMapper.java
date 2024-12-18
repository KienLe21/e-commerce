package com.example.GEEKUP_test.Mapper;

import com.example.GEEKUP_test.DTO.UserDTO;
import com.example.GEEKUP_test.Model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
}
