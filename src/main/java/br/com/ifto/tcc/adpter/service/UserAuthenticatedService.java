package br.com.ifto.tcc.adpter.service;

import br.com.ifto.tcc.core.port.UserAuthenticatedPort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticatedService implements UserAuthenticatedPort {

  @Override
  public String getUserId() {
    final var jwt = (Jwt) getAuthentication().getPrincipal();
    return jwt.getClaim("id");
  }

  private Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }

}
