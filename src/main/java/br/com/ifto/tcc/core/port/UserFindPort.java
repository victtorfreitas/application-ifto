package br.com.ifto.tcc.core.port;

public interface UserFindPort {

  boolean existsByEmail(String email);
}
