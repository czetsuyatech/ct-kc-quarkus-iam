package com.hivemaster.jwt.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TokenExtensionProcessor {

  @JsonProperty("name")
  private final String name;
}
