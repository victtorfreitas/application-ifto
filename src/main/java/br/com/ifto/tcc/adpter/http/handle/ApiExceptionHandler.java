package br.com.ifto.tcc.adpter.http.handle;

import br.com.ifto.tcc.adpter.http.handle.Problem.Type;
import br.com.ifto.tcc.core.exception.PasswordOldInvalidException;
import br.com.ifto.tcc.core.exception.UserEmailAlreadyUsedException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  private final MessageSource messageSource;

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
      HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    return ResponseEntity.status(status).headers(headers).build();
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    return handleValidationInternal(ex, headers, status, request, ex.getBindingResult());
  }


  @Override
  protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {

    return handleValidationInternal(ex, headers, status, request, ex.getBindingResult());
  }

  @ExceptionHandler(UserEmailAlreadyUsedException.class)
  public ResponseEntity<?> handleUserEmailAlreadyUsedException(UserEmailAlreadyUsedException ex,
      WebRequest request) {

    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

    String detail = ex.getMessage();
    var typeErro = Type.EMAIL_ALREADY_USED;

    Problem problem = Problem.builder()
        .title(typeErro.getTitle())
        .type(typeErro)
        .detail(detail)
        .userMessage(detail)
        .timestamp(OffsetDateTime.now())
        .build();

    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }

  @ExceptionHandler(PasswordOldInvalidException.class)
  public ResponseEntity<?> handleUserEmailAlreadyUsedException(PasswordOldInvalidException ex,
      WebRequest request) {

    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

    String detail = ex.getMessage();
    var typeErro = Type.CURRENT_PASSWORD_INVALID;

    Problem problem = Problem.builder()
        .title(typeErro.getTitle())
        .type(typeErro)
        .detail(detail)
        .userMessage(detail)
        .timestamp(OffsetDateTime.now())
        .build();

    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }

  private ResponseEntity<Object> handleValidationInternal(Exception ex, HttpHeaders headers,
      HttpStatus status, WebRequest request, BindingResult bindingResult) {
    String detail = "One or more field are invalid. Please fill in correctly and try again.";

    List<Problem.Erro> problemObjects = bindingResult.getAllErrors().stream()
        .map(objectError -> {
          String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());

          String name = objectError.getObjectName();

          if (objectError instanceof FieldError) {
            name = ((FieldError) objectError).getField();
          }

          return Problem.Erro.builder()
              .field(name)
              .message(message)
              .build();
        })
        .collect(Collectors.toList());

    final var typeErro = Type.INVALID_FIELDS;
    Problem problem = Problem.builder()
        .title(typeErro.getTitle())
        .type(typeErro)
        .detail(detail)
        .userMessage(detail)
        .timestamp(OffsetDateTime.now())
        .errors(problemObjects)
        .build();

    return handleExceptionInternal(ex, problem, headers, status, request);
  }
}
