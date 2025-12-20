package com.noanka.swapper.module.inventory.controller;

import com.noanka.swapper.data.http.response.ResponseListBase;
import com.noanka.swapper.module.inventory.controller.http.dto.TypeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("asset/type")
@Tag(name = "Inventory", description = "inventory services")
public class TypeController {

    @Operation(summary = "getting asset type options")
    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseListBase<TypeDto> GetAssetTypes(@AuthenticationPrincipal Jwt jwt){
        throw new NotImplementedException();
    }
}
