package com.example.infaqservice.repository;

import com.example.infaqservice.model.TemporaryToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporaryTokenRepository extends JpaRepository<TemporaryToken, Long> {
}
