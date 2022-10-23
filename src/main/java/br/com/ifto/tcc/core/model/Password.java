package br.com.ifto.tcc.core.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Password {

  private String uuid;
  private String oldPassword;
  private String newPassword;

}
