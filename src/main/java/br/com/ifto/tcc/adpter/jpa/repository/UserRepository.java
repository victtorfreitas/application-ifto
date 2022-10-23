package br.com.ifto.tcc.adpter.jpa.repository;

import br.com.ifto.tcc.adpter.jpa.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByUuid(String uuid);

  boolean existsByEmail(String email);

}
