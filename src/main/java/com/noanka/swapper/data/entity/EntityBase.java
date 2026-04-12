package com.noanka.swapper.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Data
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, columnDefinition = "TIMESTAMPTZ")
    private Long createdAt;
    @Column(nullable = true, columnDefinition = "TIMESTAMPTZ")
    private Long updatedAt;
    @Column(nullable = false)
    private boolean isActive;

    @PrePersist
    protected void onCreate() {
        this.createdAt = System.currentTimeMillis();
        this.isActive = true;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = System.currentTimeMillis();
    }

    @Converter(autoApply = false)
    public static class EpochTimeConverter implements AttributeConverter<Long, OffsetDateTime> {

        @Override
        public OffsetDateTime convertToDatabaseColumn(Long epochMillis) {
            if (epochMillis == null) return null;
            return OffsetDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), ZoneOffset.UTC);
        }

        @Override
        public Long convertToEntityAttribute(OffsetDateTime dateTime) {
            if (dateTime == null) return null;
            return dateTime.toInstant().toEpochMilli();
        }
    }
}
