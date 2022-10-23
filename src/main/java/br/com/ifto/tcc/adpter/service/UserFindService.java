package br.com.ifto.tcc.adpter.service;

import br.com.ifto.tcc.adpter.jpa.mapper.UserEntityMapper;
import br.com.ifto.tcc.adpter.jpa.repository.UserRepository;
import br.com.ifto.tcc.core.exception.UserNotFoundException;
import br.com.ifto.tcc.core.model.User;
import br.com.ifto.tcc.core.port.UserFindPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFindService implements UserFindPort {

  private final UserRepository userRepository;
  private final UserEntityMapper userEntityMapper;

  @Override
  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  @Override
  public User findByUuid(String uuid) {
    final var userEntity = userRepository.findByUuid(uuid)
        .orElseThrow(() -> new UserNotFoundException(uuid));
    return userEntityMapper.convert(userEntity);
  }
}
