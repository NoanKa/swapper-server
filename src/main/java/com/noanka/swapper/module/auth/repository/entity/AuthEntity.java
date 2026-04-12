package com.noanka.swapper.module.auth.repository.entity;

import com.noanka.swapper.data.entity.EntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "Auth")
public class AuthEntity extends EntityBase {
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
}
