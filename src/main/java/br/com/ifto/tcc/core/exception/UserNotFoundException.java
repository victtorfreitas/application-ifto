package br.com.ifto.tcc.core.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {

  private final String uuid;

  public UserNotFoundException(String uuid) {
    super(String.format("User not found by id %s", uuid));
    this.uuid = uuid;
  }
}
