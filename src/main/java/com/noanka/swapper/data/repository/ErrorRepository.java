package com.noanka.swapper.data.repository;

import com.noanka.swapper.data.entity.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ErrorRepository extends JpaRepository<ErrorEntity, UUID> {
    @Query("""
        SELECT DISTINCT e
        FROM ErrorEntity e
        JOIN FETCH e.errorMessages m
        WHERE e.isActive = true
          AND m.isActive = true
    """)
    List<ErrorEntity> findErrorsWithMessages();
}
