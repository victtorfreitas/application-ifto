package br.com.ifto.tcc.adpter.http.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PasswordUpdateRequest {

  @NotBlank
  @Size(min = 3, max = 200)
  private String oldPassword;

  @NotBlank
  @Size(min = 3, max = 200)
  private String newPassword;
}
