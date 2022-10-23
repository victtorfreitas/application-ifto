package br.com.ifto.tcc.core.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class User {

  private final UUID uuid = UUID.randomUUID();
  private String name;
  private String email;

  @ToString.Exclude
  private String password;
}
