package com.hivemaster.jwt.utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TokenExtensionProcessor {

  private final String name;
}
