package com.ingjulianvega.testspecification.services;

import com.ingjulianvega.testspecification.web.model.User;
import com.ingjulianvega.testspecification.web.model.UserDto;
import com.ingjulianvega.testspecification.web.model.UserList;

import java.util.UUID;

public interface UserService {
    UserList get();

    UserDto getById(UUID id);

    void create(User user);

    void updateById(UUID id, User user);

    void deleteById(UUID id);
}
