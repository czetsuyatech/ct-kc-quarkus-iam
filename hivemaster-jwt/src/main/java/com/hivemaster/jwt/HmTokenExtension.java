package com.hivemaster.jwt;

import com.hivemaster.jwt.dto.user.UserData;
import com.hivemaster.jwt.utils.TokenExtensionProcessor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HmTokenExtension {

  private TokenExtensionProcessor[] tep;
  private UserData userData;
}
