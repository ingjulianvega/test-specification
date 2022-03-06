package com.ingjulianvega.testspecification.domain.repositories;

import com.ingjulianvega.testspecification.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID>, JpaSpecificationExecutor<UserEntity> {
    List<UserEntity> findAllByOrderByFirstName();
}
