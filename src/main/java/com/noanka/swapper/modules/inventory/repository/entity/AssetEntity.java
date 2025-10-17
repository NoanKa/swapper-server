package com.noanka.swapper.modules.inventory.repository.entity;

import com.noanka.swapper.modules.profile.repository.entity.UserEntity;
import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "Asset")
public class AssetEntity extends EntityBase {
    @Column(nullable = false, length = 50)
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "AssetType",
            joinColumns = @JoinColumn(name = "assetId"),
            inverseJoinColumns = @JoinColumn(name = "typeId")
    )
    private List<TypeEntity> types;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "assetId")
    private List<AttributeEntity> attributes;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity owner;
}
