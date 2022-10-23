package br.com.ifto.tcc.core.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class User {

  private String uuid;
  private String name;
  private String email;

  @ToString.Exclude
  private String password;

  public String getUuidStartUp() {
    final var uuid = UUID.randomUUID().toString();
    this.uuid = uuid;
    return uuid;
  }
}
