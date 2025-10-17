package com.noanka.swapper.modules.auth.repository;

import com.noanka.swapper.modules.auth.repository.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, UUID> {
}
