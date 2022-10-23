package br.com.ifto.tcc.adpter.jpa.repository;

import br.com.ifto.tcc.adpter.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  boolean existsByEmail(String email);
}
