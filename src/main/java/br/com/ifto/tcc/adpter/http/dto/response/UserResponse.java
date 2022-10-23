package br.com.ifto.tcc.adpter.http.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {

  private String id;
  private String name;
  private String email;
}
