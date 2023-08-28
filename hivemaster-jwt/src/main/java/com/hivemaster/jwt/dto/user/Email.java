package com.hivemaster.jwt.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {

  private final String address;
  private final boolean isDefaultEmail;
}
