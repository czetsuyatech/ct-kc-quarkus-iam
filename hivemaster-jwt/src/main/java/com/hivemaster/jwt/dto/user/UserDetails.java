package com.hivemaster.jwt.dto.user;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

  private Organization organization;
  private String eid;
  private String firstName;
  private String lastName;
  private Collection<Email> emails;
  private Collection<Role> roles;
}
