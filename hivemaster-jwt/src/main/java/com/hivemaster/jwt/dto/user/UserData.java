package com.hivemaster.jwt.dto.user;

import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserData {

  private final UserType type;

  private final UserDetails details;

  @Data
  @Builder
  public static class UserDetails {

    private final String eid;
    private final String firstName;
    private final String lastName;
    private final Collection<String> hmGroups;
  }
}
