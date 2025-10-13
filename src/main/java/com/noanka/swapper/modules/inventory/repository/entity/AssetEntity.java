package com.noanka.swapper.modules.inventory.repository.entity;

import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "Asset")
public class AssetEntity extends EntityBase {
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private UUID userId;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "AssetType",
            joinColumns = @JoinColumn(name = "assetId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "typeId", referencedColumnName = "id")
    )
    private List<TypeEntity> types;
    @JoinTable(
            name = "AssetAttribute",
            joinColumns = @JoinColumn(name = "assetId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "attributeId", referencedColumnName = "id")
    )
    private List<AttributeEntity> attributes;
}
