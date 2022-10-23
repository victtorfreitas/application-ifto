package br.com.ifto.tcc.core.exception;

public class PasswordOldInvalidException extends RuntimeException {

  public PasswordOldInvalidException() {
    super("Current password is invalid");
  }
}
