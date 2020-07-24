package dev.naman.userservice.repository;

import dev.naman.userservice.model.PasswordResetToken;
import dev.naman.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordResetToken,Long> {

    PasswordResetToken findByToken(String token);
}
