package com.noanka.swapper.modules.inventory.repository;


import com.noanka.swapper.modules.inventory.repository.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, UUID> {
}
