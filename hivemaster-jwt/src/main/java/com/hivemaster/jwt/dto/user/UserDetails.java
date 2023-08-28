package com.hivemaster.jwt.dto.user;

import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetails {

  private final String eid;
  private final String firstName;
  private final String lastName;
  private final Collection<Email> emails;
  private final Collection<Role> roles;
}
