package br.com.ifto.tcc.adpter.service;

import br.com.ifto.tcc.adpter.jpa.repository.UserRepository;
import br.com.ifto.tcc.core.port.UserFindPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFindService implements UserFindPort {

  private final UserRepository userRepository;

  @Override
  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }
}
