package com.noanka.swapper.modules.offer.repository.entity;

import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class CommentEntity extends EntityBase {
    @Column(nullable = false)
    private UUID userId;
    @Column(nullable = false, length = 100)
    private String message;

    @ManyToOne
    @JoinColumn(name = "offerId", nullable = false)
    private OfferEntity offer;
}
