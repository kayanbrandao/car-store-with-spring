package com.carstorewithspring.data.mapper;

import com.carstorewithspring.data.dto.UserDto;
import com.carstorewithspring.data.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDto toResponse(User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }

    public static List<UserDto> toResponse(List<User> users){
        List<UserDto> UserDto = new ArrayList<>();

        for (User user : users) {
            UserDto.add(new UserDto(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getRole()
            ));
        }

        return UserDto;
    }
}
