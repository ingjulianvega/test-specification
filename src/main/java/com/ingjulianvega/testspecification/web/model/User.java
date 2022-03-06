package com.ingjulianvega.testspecification.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @NotBlank
  private String firstName = null;
  @NotBlank
  private String lastName = null;
  @NotBlank
  private String email = null;
  @Positive
  private int age;

}

