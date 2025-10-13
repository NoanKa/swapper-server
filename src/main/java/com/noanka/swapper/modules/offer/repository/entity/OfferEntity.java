package com.noanka.swapper.modules.offer.repository.entity;

import com.noanka.swapper.modules.inventory.repository.entity.AssetEntity;
import com.noanka.swapper.modules.profile.repository.entity.UserEntity;
import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Offer")
public class OfferEntity extends EntityBase {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "myAssetId")
    private AssetEntity myAsset;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "askedAssetId")
    private AssetEntity askedAsset;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity owner;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<CommentEntity> comments;
}
