package com.noanka.swapper.module.inventory.repository.entity;

import com.noanka.swapper.data.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "Attribute")
public class AttributeEntity extends EntityBase {
    @Column(nullable = false, length = 20)
    private String key;
    @Column(nullable = false, length = 20)
    private String value;
}
