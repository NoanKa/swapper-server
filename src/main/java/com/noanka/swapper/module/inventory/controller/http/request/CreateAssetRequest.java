package com.noanka.swapper.module.inventory.controller.http.request;

import com.noanka.swapper.module.inventory.controller.http.dto.AttributeDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CreateAssetRequest {
    @NotNull
    @Size(max = 50)
    private String name;
    private List<Integer> typeIds;
    private List<AttributeDto> attributes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(List<Integer> typeIds) {
        this.typeIds = typeIds;
    }

    public List<AttributeDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDto> attributes) {
        this.attributes = attributes;
    }
}
