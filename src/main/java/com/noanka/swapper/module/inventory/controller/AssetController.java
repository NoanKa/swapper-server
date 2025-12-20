package com.noanka.swapper.module.inventory.controller;

import com.noanka.swapper.data.http.response.ResponseBase;
import com.noanka.swapper.data.http.response.ResponseListBase;
import com.noanka.swapper.module.inventory.controller.http.dto.AssetDto;
import com.noanka.swapper.module.inventory.controller.http.request.CreateAssetRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("asset")
@Tag(name = "Inventory", description = "inventory services")
public class AssetController {

    @Operation(summary = "getting user's assets")
    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseListBase<AssetDto> GetUserAssets(@AuthenticationPrincipal Jwt jwt){
        throw new NotImplementedException();
    }

    @Operation(summary = "creating a new asset")
    @PostMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase CreateAsset(@AuthenticationPrincipal Jwt jwt, @Valid @RequestBody CreateAssetRequest createAssetRequest){
        throw new NotImplementedException();
    }

    @Operation(summary = "deleting a user asset")
    @DeleteMapping("{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase DeleteAsset(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id){
        throw new NotImplementedException();
    }
}
