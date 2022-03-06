package com.ingjulianvega.testspecification.services;

import com.ingjulianvega.testspecification.configuration.ErrorCodeMessages;
import com.ingjulianvega.testspecification.domain.UserEntity;
import com.ingjulianvega.testspecification.domain.repositories.UserRepository;
import com.ingjulianvega.testspecification.exception.UserException;
import com.ingjulianvega.testspecification.web.Mappers.UserMapper;
import com.ingjulianvega.testspecification.web.model.User;
import com.ingjulianvega.testspecification.web.model.UserDto;
import com.ingjulianvega.testspecification.web.model.UserList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Cacheable(cacheNames = "userListCache")
    @Override
    public UserList get() {
        log.debug("get()...");
        return UserList
                .builder()
                .userList(userMapper.userEntityListToUserDtoList(userRepository.findAllByOrderByFirstName()))
                .build();
    }

    @Cacheable(cacheNames = "userCache")
    @Override
    public UserDto getById(UUID id) {
        log.debug("getById()...");
        return userMapper.userEntityToUserDto(
                userRepository.findById(id).orElseThrow(() -> UserException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.USER_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.USER_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.USER_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.USER_NOT_FOUND_SOLUTION)
                        .build()));
    }

    @Override
    public void create(User user) {
        log.debug("create()...");
        userMapper.userEntityToUserDto(
                userRepository.save(
                        userMapper.userDtoToUserEntity(
                                UserDto
                                        .builder()
                                        .firstName(user.getFirstName())
                                        .lastName(user.getLastName())
                                        .email(user.getEmail())
                                        .age(user.getAge())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, User user) {
        log.debug("updateById...");
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> UserException
                .builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .apiCode(ErrorCodeMessages.USER_NOT_FOUND_API_CODE)
                .error(ErrorCodeMessages.USER_NOT_FOUND_ERROR)
                .message(ErrorCodeMessages.USER_NOT_FOUND_MESSAGE)
                .solution(ErrorCodeMessages.USER_NOT_FOUND_SOLUTION)
                .build());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setAge(user.getAge());

        userRepository.save(userEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        userRepository.deleteById(id);
    }
}
