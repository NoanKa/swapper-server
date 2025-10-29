package com.noanka.swapper.modules.offer.repository.entity;

import com.noanka.swapper.modules.profile.repository.entity.UserEntity;
import com.noanka.swapper.utilities.entity.EntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Comment")
public class CommentEntity extends EntityBase {
    @Column(nullable = false, length = 100)
    private String message;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity owner;
}
