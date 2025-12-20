package com.noanka.swapper.module.offer.controller;

import com.noanka.swapper.data.http.response.ResponseBase;
import com.noanka.swapper.data.http.response.ResponseListBase;
import com.noanka.swapper.module.offer.controller.http.dto.OfferDto;
import com.noanka.swapper.module.offer.controller.http.request.CreateOfferRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Offer", description = "asset offer services")
public class OfferController {

    @Operation(summary = "getting feed and comment requested offers")
    @GetMapping("offer")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseListBase<OfferDto> GetOffers(@RequestParam(defaultValue = "false") Boolean requested){
        throw new NotImplementedException();
    }

    @Operation(summary = "getting user owned and offered offers")
    @GetMapping("user/offer")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseListBase<OfferDto> GetUserOffers(@AuthenticationPrincipal Jwt jwt, @RequestParam(defaultValue = "false") Boolean owned){
        throw new NotImplementedException();
    }

    @Operation(summary = "creating new offer")
    @PostMapping("offer")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase CreateOffer(@AuthenticationPrincipal Jwt jwt, @RequestBody CreateOfferRequest offerRequest){
        throw new NotImplementedException();
    }

    @Operation(summary = "deleting user's offer")
    @DeleteMapping("offer/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase DeleteOffer(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id){
        throw new NotImplementedException();
    }
}
