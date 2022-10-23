package br.com.ifto.tcc.adpter.http.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class NewUserRequest {

  @NotBlank
  @Size(min = 3, max = 250)
  private String name;

  @Email
  @NotNull
  @Size(min = 7, max = 250)
  private String email;

  @NotBlank
  @ToString.Exclude
  @Size(min = 3, max = 250)
  private String password;
}
