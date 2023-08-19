package com.hivemaster.jwt;

import com.hivemaster.jwt.dto.user.UserData;
import com.hivemaster.jwt.utils.TokenExtensionProcessor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HmTokenExtension {

  private final TokenExtensionProcessor[] tep;
  private final UserData userData;
}
