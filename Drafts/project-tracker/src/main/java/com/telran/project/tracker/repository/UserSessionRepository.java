package com.telran.project.tracker.repository;

import com.telran.project.tracker.model.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {

    UserSession findBySessionIdAndIsValidTrue(String sessionId);
}
