package com.noanka.swapper.module.profile.controller;

import com.noanka.swapper.module.profile.controller.http.dto.UserDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Tag(name = "User", description = "user services")
public class UserController {

    @GetMapping
    @SecurityRequirement(name = "bearerAuth") // default requirement
    public UserDto GetUserProfile(@AuthenticationPrincipal Jwt jwt){
        throw new NotImplementedException();
    }
}
