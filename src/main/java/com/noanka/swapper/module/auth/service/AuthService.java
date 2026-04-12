package com.noanka.swapper.module.auth.service;

import com.noanka.swapper.data.constant.BusinessException;
import com.noanka.swapper.data.constant.InfoCode;
import com.noanka.swapper.data.http.response.ResponseBase;
import com.noanka.swapper.module.auth.controller.http.dto.TokenDto;
import com.noanka.swapper.module.auth.controller.http.request.LoginRequest;
import com.noanka.swapper.module.auth.controller.http.request.RegisterRequest;
import com.noanka.swapper.module.auth.repository.AuthRepository;
import com.noanka.swapper.module.auth.repository.entity.AuthEntity;
import com.noanka.swapper.module.profile.repository.UserRepository;
import com.noanka.swapper.module.profile.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class AuthService{
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseBase Register(RegisterRequest request) throws BusinessException {
        if(authRepository.existsByUsernameAndIsActive(request.getEmail(), true)){
            throw new BusinessException("Email already exists");
        }
        AuthEntity authEntity = AuthEntity.builder()
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .build();
        UserEntity userEntity = UserEntity.builder()
                .name(request.getName())
                .lastName(request.getLastname())
                .birthdate(request.getBirthdate())
                .auth(authEntity)
                .build();

        userRepository.save(userEntity);

        return new ResponseBase<Void>(InfoCode.USER_CREATED, true);
    }

    public ResponseBase<TokenDto> Login(LoginRequest request){
        return new ResponseBase<TokenDto>(new TokenDto(),null, null, true);
    }

    public ResponseBase<TokenDto> Refresh(String accessToken, String refreshToken){
        return new ResponseBase<TokenDto>(new TokenDto(), null, null, true);
    }
}
