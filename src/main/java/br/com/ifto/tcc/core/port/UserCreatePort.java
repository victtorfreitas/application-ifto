package br.com.ifto.tcc.core.port;

import br.com.ifto.tcc.core.model.User;

public interface UserCreatePort {
  void createUser(User user);

  void updatePassword(String uuid, String newPassword);
}
