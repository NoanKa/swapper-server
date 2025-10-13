package com.noanka.swapper.modules.inventory.repository.entity;

import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Type")
public class TypeEntity extends EntityBase {
    @Column(nullable = false, unique = true)
    private Integer typeId;
    @Column(nullable = false, length = 10)
    private String name;
}
