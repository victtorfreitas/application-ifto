package br.com.ifto.tcc.core.port;

import br.com.ifto.tcc.core.model.Password;
import br.com.ifto.tcc.core.model.User;

public interface UserValidatePort {
  User validateUser(User user);

  void validatePassword(Password password);
}
