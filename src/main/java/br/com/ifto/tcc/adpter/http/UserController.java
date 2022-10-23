package br.com.ifto.tcc.adpter.http;

import static org.springframework.http.HttpStatus.CREATED;

import br.com.ifto.tcc.adpter.http.dto.request.NewUserRequest;
import br.com.ifto.tcc.adpter.http.dto.response.UserResponse;
import br.com.ifto.tcc.adpter.http.mapper.UserMapper;
import br.com.ifto.tcc.core.port.UserValidatePort;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final UserValidatePort userValidatePort;
  private final UserMapper userMapper;

  @PostMapping
  @ResponseStatus(CREATED)
  public UserResponse createNewUser(@RequestBody @Valid NewUserRequest userRequest) {
    final var user = userValidatePort.validateUser(userMapper.convert(userRequest));
    return userMapper.convert(user);
  }
}
