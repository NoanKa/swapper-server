package com.noanka.swapper.module.profile.repository.entity;

import com.noanka.swapper.module.auth.repository.entity.AuthEntity;
import com.noanka.swapper.module.inventory.repository.entity.AssetEntity;
import com.noanka.swapper.data.entity.EntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AppUser")
public class UserEntity extends EntityBase {
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false)
    private LocalDate birthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authId")
    private AuthEntity auth;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<AssetEntity> assets;
}
