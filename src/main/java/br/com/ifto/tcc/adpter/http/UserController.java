package br.com.ifto.tcc.adpter.http;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import br.com.ifto.tcc.adpter.http.dto.request.NewUserRequest;
import br.com.ifto.tcc.adpter.http.dto.request.PasswordUpdateRequest;
import br.com.ifto.tcc.adpter.http.dto.response.UserResponse;
import br.com.ifto.tcc.adpter.http.mapper.PasswordMapper;
import br.com.ifto.tcc.adpter.http.mapper.UserMapper;
import br.com.ifto.tcc.core.port.UserAuthenticatedPort;
import br.com.ifto.tcc.core.port.UserValidatePort;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserValidatePort userValidatePort;
  private final UserAuthenticatedPort userAuthenticatedPort;
  private final UserMapper userMapper;
  private final PasswordMapper passwordMapper;

  @PostMapping
  @ResponseStatus(CREATED)
  public UserResponse createNewUser(@RequestBody @Valid NewUserRequest userRequest) {
    log.info("Initialing flow create user {} by USER_ID: {}", userRequest,
        userAuthenticatedPort.getUserId());
    final var user = userValidatePort.validateUser(userMapper.convert(userRequest));
    return userMapper.convert(user);
  }

  @PatchMapping("/{id}/password")
  @ResponseStatus(NO_CONTENT)
  public void updatePassword(@PathVariable("id") String id,
      @RequestBody @Valid PasswordUpdateRequest passwordUpdateRequest) {
    final var password = passwordMapper.convert(id, passwordUpdateRequest);
    userValidatePort.validatePassword(password);
  }
}
