package br.com.ifto.tcc.adpter.jpa.mapper;

import br.com.ifto.tcc.adpter.jpa.entity.UserEntity;
import br.com.ifto.tcc.core.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

  public UserEntity convert(User user) {
    return UserEntity.builder()
        .uuid(user.getUuidStartUp())
        .name(user.getName())
        .email(user.getEmail())
        .password(user.getPassword())
        .build();
  }

  public User convert(UserEntity userEntity) {
    return User.builder()
        .name(userEntity.getName())
        .uuid(userEntity.getUuid())
        .password(userEntity.getPassword())
        .email(userEntity.getEmail())
        .build();
  }
}
