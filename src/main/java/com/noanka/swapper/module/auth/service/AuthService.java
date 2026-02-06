package com.noanka.swapper.module.auth.service;

import com.noanka.swapper.data.http.response.ResponseBase;
import com.noanka.swapper.module.auth.controller.http.dto.TokenDto;
import com.noanka.swapper.module.auth.controller.http.request.LoginRequest;
import com.noanka.swapper.module.auth.controller.http.request.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService{
    public ResponseBase Register(RegisterRequest request){
        return new ResponseBase<Void>(null, null, true);
    }

    public ResponseBase<TokenDto> Login(LoginRequest request){
        return new ResponseBase<TokenDto>(new TokenDto(),null, null, true);
    }

    public ResponseBase<TokenDto> Refresh(String accessToken, String refreshToken){
        return new ResponseBase<TokenDto>(new TokenDto(), null, null, true);
    }
}
