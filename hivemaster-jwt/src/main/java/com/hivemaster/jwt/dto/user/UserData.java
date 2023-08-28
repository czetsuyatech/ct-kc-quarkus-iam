package com.hivemaster.jwt.dto.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserData {

  private final UserType type;

  private final UserDetails details;
}
