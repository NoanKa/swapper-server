package com.noanka.swapper.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ErrorMessage")
public class ErrorMessageEntity extends EntityBase{
    @Column(nullable = false)
    private String message;
}
