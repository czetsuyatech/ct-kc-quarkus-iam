package com.hivemaster.jwt;

import com.hivemaster.jwt.dto.user.UserData;
import com.hivemaster.jwt.utils.TokenExtensionProcessor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CtTokenExtension {

  @JsonProperty("tep")
  private final TokenExtensionProcessor[] tep;

  @JsonProperty("userData")
  private final UserData userData;
}
