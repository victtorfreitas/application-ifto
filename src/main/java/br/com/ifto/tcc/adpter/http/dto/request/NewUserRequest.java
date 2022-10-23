package br.com.ifto.tcc.adpter.http.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class NewUserRequest {

  @NotBlank
  private String name;
  @NotBlank
  private String email;

  @NotBlank
  @ToString.Exclude
  private String password;
}
