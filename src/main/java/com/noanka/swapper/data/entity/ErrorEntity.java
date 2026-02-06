package com.noanka.swapper.data.entity;

import com.noanka.swapper.data.constant.ErrorCode;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Error")
public class ErrorEntity extends EntityBase{
    @Enumerated(EnumType.STRING)
    private ErrorCode errorCode;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "errorId")
    private List<ErrorMessageEntity> errorMessages;
}
