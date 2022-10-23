package br.com.ifto.tcc.core.exception;

import static java.lang.String.format;

import lombok.Getter;

@Getter
public class UserEmailAlreadyUsedException extends RuntimeException {

  private final String email;

  public UserEmailAlreadyUsedException(String email) {
    super(format("This %s already used.", email));
    this.email = email;
  }
}
