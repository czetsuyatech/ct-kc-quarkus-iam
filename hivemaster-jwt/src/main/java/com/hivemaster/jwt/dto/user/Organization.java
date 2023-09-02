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
public class Organization {

  private String code;
  private Collection<String> apps;
}
