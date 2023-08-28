package com.hivemaster.jwt.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {

  private final String applicationCode;
  private final String name;
}
