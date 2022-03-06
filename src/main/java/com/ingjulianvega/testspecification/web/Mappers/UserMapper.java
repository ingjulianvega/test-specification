package com.ingjulianvega.testspecification.web.Mappers;

import com.ingjulianvega.testspecification.domain.UserEntity;
import com.ingjulianvega.testspecification.web.model.UserDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface UserMapper {
    UserDto userEntityToUserDto(UserEntity maritalStatusEntity);

    UserEntity userDtoToUserEntity(UserDto maritalStatusDto);

    ArrayList<UserDto> userEntityListToUserDtoList(List<UserEntity> maritalStatusEntityList);
}
