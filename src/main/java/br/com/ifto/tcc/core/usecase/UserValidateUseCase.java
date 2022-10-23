package br.com.ifto.tcc.core.usecase;

import br.com.ifto.tcc.core.exception.UserEmailAlreadyUsedException;
import br.com.ifto.tcc.core.model.User;
import br.com.ifto.tcc.core.port.UserCreatePort;
import br.com.ifto.tcc.core.port.UserFindPort;
import br.com.ifto.tcc.core.port.UserValidatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidateUseCase implements UserValidatePort {

  private final UserFindPort userFindPort;
  private final UserCreatePort userCreatePort;

  @Override
  public User validateUser(User user) {
    final var email = user.getEmail();

    if (userFindPort.existsByEmail(email)) {
      throw new UserEmailAlreadyUsedException(email);
    }

    userCreatePort.createUser(user);

    return user;
  }
}
