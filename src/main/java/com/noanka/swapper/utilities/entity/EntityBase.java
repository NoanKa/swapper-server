package com.noanka.swapper.utilities.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
