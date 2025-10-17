package com.noanka.swapper.modules.auth.repository.entity;

import com.noanka.swapper.modules.profile.repository.entity.UserEntity;
import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Auth")
public class AuthEntity extends EntityBase {
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
}
