package com.ingjulianvega.testspecification.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserList implements Serializable {

  static final long serialVersionUID = -8166892959554330323L;

  public ArrayList<UserDto> userList;

}

