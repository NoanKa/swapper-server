package com.noanka.swapper.module.offer.repository.entity;

import com.noanka.swapper.module.profile.repository.entity.UserEntity;
import com.noanka.swapper.data.entity.EntityBase;
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
    @Column(nullable = false)
    private Float rate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity owner;
}
