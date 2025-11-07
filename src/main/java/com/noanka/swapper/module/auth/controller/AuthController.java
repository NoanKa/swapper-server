package com.noanka.swapper.module.auth.controller;

import com.noanka.swapper.module.auth.controller.http.dto.TokenDto;
import com.noanka.swapper.module.auth.controller.http.request.LoginRequest;
import com.noanka.swapper.module.auth.controller.http.request.RegisterRequest;
import com.noanka.swapper.data.http.response.ResponseBase;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Auth", description = "onboarding services")
public class AuthController {
    @PostMapping("register")
    public ResponseBase<TokenDto> Register(@Valid @RequestBody RegisterRequest registerRequest){
        throw new NotImplementedException();
    }

    @PostMapping("login")
    public ResponseBase<TokenDto> Login(@Valid @RequestBody LoginRequest loginRequest){
        throw new NotImplementedException();
    }

    @GetMapping("refresh")
    public ResponseBase<TokenDto> Refresh(@RequestHeader("access-token") String accessToken, @RequestHeader("refresh-token") String refreshToken){
        throw new NotImplementedException();
    }
}
