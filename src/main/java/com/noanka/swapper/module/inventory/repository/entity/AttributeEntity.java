package com.noanka.swapper.module.inventory.repository.entity;

import com.noanka.swapper.utility.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Attribute")
public class AttributeEntity extends EntityBase {
    @Column(nullable = false, length = 20)
    private String key;
    @Column(nullable = false, length = 20)
    private String value;
}
