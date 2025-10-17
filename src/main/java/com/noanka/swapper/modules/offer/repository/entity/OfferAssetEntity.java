package com.noanka.swapper.modules.offer.repository.entity;

import com.noanka.swapper.modules.inventory.repository.entity.AssetEntity;
import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "OfferAsset")
public class OfferAssetEntity extends EntityBase {
    @Column(nullable = false)
    @Convert(converter = BooleanToStringConverter.class)
    private boolean offerOrAsset;

    @ManyToOne
    @JoinColumn(name = "assetId")
    private AssetEntity item;

    @Converter
    public static class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

        @Override
        public String convertToDatabaseColumn(Boolean attribute) {
            return attribute ? "OFFER" : "ASSET";
        }

        @Override
        public Boolean convertToEntityAttribute(String dbData) {
            return dbData.equalsIgnoreCase("OFFER");
        }
    }
}
