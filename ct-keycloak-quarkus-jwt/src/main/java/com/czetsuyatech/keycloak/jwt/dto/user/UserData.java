package com.czetsuyatech.keycloak.jwt.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserData {

  @JsonProperty("type")
  private final UserType type;

  @JsonProperty("details")
  private final UserDetails details;

  @Data
  @Builder
  public static class UserDetails {

    @JsonProperty("eid")
    private final String eid;

    @JsonProperty("firstName")
    private final String firstName;

    @JsonProperty("lastName")
    private final String lastName;

    @JsonProperty("ctGroups")
    private final Collection<String> ctGroups;
  }
}
