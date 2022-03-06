package com.ingjulianvega.testspecification.web.controller;

import com.ingjulianvega.testspecification.services.UserService;
import com.ingjulianvega.testspecification.web.model.User;
import com.ingjulianvega.testspecification.web.model.UserDto;
import com.ingjulianvega.testspecification.web.model.UserList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserI {
    private final UserService userService;

    @Override
    public ResponseEntity<UserList> get() {
        return new ResponseEntity<>(userService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid User user) {
        userService.updateById(id, user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}