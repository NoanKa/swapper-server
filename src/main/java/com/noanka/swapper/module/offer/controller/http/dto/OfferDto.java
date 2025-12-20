package com.noanka.swapper.module.offer.controller.http.dto;

import com.noanka.swapper.module.inventory.controller.http.dto.AssetDto;

import java.util.List;
import java.util.UUID;

public class OfferDto {
    private UUID id;
    private List<AssetDto> offeredAssets;
    private UUID offerOwner;
    private String offerOwnerFullname;
    private List<CommentDto> comments;

    public List<AssetDto> getOfferedAssets() {
        return offeredAssets;
    }

    public void setOfferedAssets(List<AssetDto> offeredAssets) {
        this.offeredAssets = offeredAssets;
    }

    public UUID getOfferOwner() {
        return offerOwner;
    }

    public void setOfferOwner(UUID offerOwner) {
        this.offerOwner = offerOwner;
    }

    public String getOfferOwnerFullname() {
        return offerOwnerFullname;
    }

    public void setOfferOwnerFullname(String offerOwnerFullname) {
        this.offerOwnerFullname = offerOwnerFullname;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
