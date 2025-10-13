package com.noanka.swapper.modules.profile.repository.entity;

import com.noanka.swapper.modules.auth.repository.entity.AuthEntity;
import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "User")
public class UserEntity extends EntityBase {
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false)
    private LocalDate birthdate;


    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private AuthEntity auth;
}
