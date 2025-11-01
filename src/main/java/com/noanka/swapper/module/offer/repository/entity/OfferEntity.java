package com.noanka.swapper.module.offer.repository.entity;

import com.noanka.swapper.module.offer.repository.type.OfferStatus;
import com.noanka.swapper.module.profile.repository.entity.UserEntity;
import com.noanka.swapper.utility.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Offer")
public class OfferEntity extends EntityBase {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "offerId")
    private List<OfferAssetEntity> assets;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity owner;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "offerId")
    private List<CommentEntity> comments;
}
