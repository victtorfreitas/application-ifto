package br.com.ifto.tcc.adpter.service;

import br.com.ifto.tcc.adpter.jpa.entity.UserEntity;
import br.com.ifto.tcc.adpter.jpa.mapper.UserEntityMapper;
import br.com.ifto.tcc.adpter.jpa.repository.UserRepository;
import br.com.ifto.tcc.core.model.User;
import br.com.ifto.tcc.core.port.UserCreatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService implements UserCreatePort {

  private final UserRepository userRepository;
  private final UserEntityMapper userEntityMapper;

  @Override
  public void createUser(User user) {
    UserEntity userEntity = userEntityMapper.convert(user);
    userRepository.save(userEntity);
  }
}
