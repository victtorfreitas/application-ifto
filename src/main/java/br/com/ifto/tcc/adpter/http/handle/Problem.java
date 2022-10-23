package br.com.ifto.tcc.adpter.http.handle;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problem {

  private OffsetDateTime timestamp;
  private Type type;
  private String title;
  private String detail;
  private String userMessage;
  private List<Erro> errors;

  @Builder
  @Getter
  public static class Erro {

    private String field;
    private String message;

  }

  @Getter
  @AllArgsConstructor
  public enum Type {
    FIELD_REQUIRED("Field is required"),
    INVALID_FIELDS("Invalid fields"),
    EMAIL_ALREADY_USED("Email already used"),
    CURRENT_PASSWORD_INVALID("Current password is invalid");

    private final String title;
  }
}
