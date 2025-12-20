package com.noanka.swapper.module.profile.controller;

import com.noanka.swapper.data.http.response.ResponseBase;
import com.noanka.swapper.module.profile.controller.http.dto.UserDto;
import com.noanka.swapper.module.profile.controller.http.request.UpdateUserProfileRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@Tag(name = "Profile", description = "user profile services")
public class UserController {

    @Operation(summary = "getting user profile")
    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase<UserDto> GetUserProfile(@AuthenticationPrincipal Jwt jwt){
        throw new NotImplementedException();
    }

    @Operation(summary = "updating user's profile")
    @PutMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase UpdateUserProfile(@AuthenticationPrincipal Jwt jwt, @RequestBody UpdateUserProfileRequest updateUserProfileRequest){
        throw new NotImplementedException();
    }
}
