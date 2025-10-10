package br.com.finflowcorp.user_service.user.application.repository;

import br.com.finflowcorp.user_service.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
