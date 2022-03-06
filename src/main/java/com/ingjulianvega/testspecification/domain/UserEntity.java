package com.ingjulianvega.testspecification.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEntity extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
