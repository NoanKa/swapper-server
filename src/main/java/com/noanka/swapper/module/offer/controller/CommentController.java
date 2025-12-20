package com.noanka.swapper.module.offer.controller;

import com.noanka.swapper.data.http.response.ResponseBase;
import com.noanka.swapper.module.offer.controller.http.request.CreateCommentRequest;
import com.noanka.swapper.module.offer.controller.http.request.CreateTicketRequest;
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
@RequestMapping("comment")
@Tag(name = "Comment", description = "asset comment services")
public class CommentController {

    @Operation(summary = "requesting analysis, rating and comment for a owned or received offer")
    @PostMapping("offer/{offerId}/request")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase RequestComment(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID offerId){
        throw new NotImplementedException();
    }

    @Operation(summary = "posting a new comment for an offer with explanation and rating")
    @PostMapping("offer/{offerId}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase CreateComment(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID offerId, @Valid @RequestBody CreateCommentRequest createCommentRequest){
        throw new NotImplementedException();
    }

    @Operation(summary = "deleting a user's comment")
    @DeleteMapping("{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase DeleteComment(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id){
        throw new NotImplementedException();
    }

    @Operation(summary = "creating ticket for comment removal")
    @PostMapping("{id}/request")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseBase DeleteCommentRequest(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id, @Valid @RequestBody CreateTicketRequest createTicketRequest){
        throw new NotImplementedException();
    }
}
