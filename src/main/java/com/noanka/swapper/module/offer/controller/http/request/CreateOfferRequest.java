package com.noanka.swapper.module.offer.controller.http.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class CreateOfferRequest {
    @NotNull
    private List<UUID> offeredAssets;
    @NotNull
    private List<UUID> wantedAssets;

    public List<UUID> getOfferedAssets() {
        return offeredAssets;
    }

    public void setOfferedAssets(List<UUID> offeredAssets) {
        this.offeredAssets = offeredAssets;
    }

    public List<UUID> getWantedAssets() {
        return wantedAssets;
    }

    public void setWantedAssets(List<UUID> wantedAssets) {
        this.wantedAssets = wantedAssets;
    }
}
