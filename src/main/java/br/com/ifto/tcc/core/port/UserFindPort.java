package br.com.ifto.tcc.core.port;

import br.com.ifto.tcc.core.model.User;

public interface UserFindPort {

  boolean existsByEmail(String email);

  User findByUuid(String uuid);
}
