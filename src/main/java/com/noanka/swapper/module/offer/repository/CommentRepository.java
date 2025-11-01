package com.noanka.swapper.module.offer.repository;

import com.noanka.swapper.module.offer.repository.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
}
