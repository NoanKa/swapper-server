package com.noanka.swapper.module.inventory.controller.http.dto;

import java.util.List;
import java.util.UUID;

public class AssetDto {
    private UUID id;
    private String name;
    private List<TypeDto> types;
    private List<AttributeDto> attributes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TypeDto> getTypes() {
        return types;
    }

    public void setTypes(List<TypeDto> types) {
        this.types = types;
    }

    public List<AttributeDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDto> attributes) {
        this.attributes = attributes;
    }
}
