package com.noanka.swapper.modules.profile.repository.entity;

import com.noanka.swapper.modules.auth.repository.entity.AuthEntity;
import com.noanka.swapper.modules.inventory.repository.entity.AssetEntity;
import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "User")
public class UserEntity extends EntityBase {

    public UserEntity(String name, String lastName, LocalDate birthdate, AuthEntity auth, List<AssetEntity> assets) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.auth = auth;
        this.assets = assets;
    }

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false)
    private LocalDate birthdate;

    @OneToOne
    @JoinColumn(name = "authId")
    private AuthEntity auth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<AssetEntity> assets;
}
