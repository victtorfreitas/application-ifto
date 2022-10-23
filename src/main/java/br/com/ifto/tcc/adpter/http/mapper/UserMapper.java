package br.com.ifto.tcc.adpter.http.mapper;

import br.com.ifto.tcc.adpter.http.dto.request.NewUserRequest;
import br.com.ifto.tcc.adpter.http.dto.response.UserResponse;
import br.com.ifto.tcc.core.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

  private final PasswordEncoder passwordEncoder;

  public User convert(NewUserRequest userRequest) {
    return User.builder()
        .name(userRequest.getName())
        .email(userRequest.getEmail())
        .password(passwordEncoder.encode(userRequest.getPassword()))
        .build();
  }

  public UserResponse convert(User user) {
    return UserResponse.builder()
        .id(user.getUuid().toString())
        .email(user.getEmail())
        .name(user.getName())
        .build();
  }
}
