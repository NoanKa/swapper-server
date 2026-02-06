package com.noanka.swapper.module.auth.controller;

import com.noanka.swapper.module.auth.controller.http.dto.TokenDto;
import com.noanka.swapper.module.auth.controller.http.request.LoginRequest;
import com.noanka.swapper.module.auth.controller.http.request.RegisterRequest;
import com.noanka.swapper.data.http.response.ResponseBase;
import com.noanka.swapper.module.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Auth", description = "onboarding services")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Operation(summary = "registering a new user")
    @PostMapping("register")
    public ResponseEntity<ResponseBase> Register(@Valid @RequestBody RegisterRequest registerRequest){
        return new ResponseEntity<ResponseBase>(authService.Register(registerRequest), HttpStatus.OK);
    }

    @Operation(summary = "login with credentials")
    @PostMapping("login")
    public ResponseEntity<ResponseBase<TokenDto>> Login(@Valid @RequestBody LoginRequest loginRequest){
        return new ResponseEntity<ResponseBase<TokenDto>>(authService.Login(loginRequest), HttpStatus.OK);
    }

    @Operation(summary = "requesting new access and refresh tokens")
    @GetMapping("refresh")
    public ResponseEntity<ResponseBase<TokenDto>> Refresh(@Valid @NotBlank @RequestHeader("access-token") String accessToken, @Valid @NotBlank @RequestHeader("refresh-token") String refreshToken){
        return new ResponseEntity<ResponseBase<TokenDto>>(authService.Refresh(accessToken, refreshToken), HttpStatus.OK);
    }
}
