package br.com.ifto.tcc.adpter.http.mapper;

import br.com.ifto.tcc.adpter.http.dto.request.PasswordUpdateRequest;
import br.com.ifto.tcc.core.model.Password;
import org.springframework.stereotype.Component;

@Component
public class PasswordMapper {

  public Password convert(String uuid, PasswordUpdateRequest passwordUpdate) {
    return Password.builder()
        .uuid(uuid)
        .oldPassword(passwordUpdate.getOldPassword())
        .newPassword(passwordUpdate.getNewPassword())
        .build();
  }
}
