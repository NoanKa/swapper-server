package com.noanka.swapper.module.offer.controller.http.dto;

import java.util.UUID;

public class CommentDto {
    private UUID id;
    private UUID commentOwner;
    private String commentOwnerFullname;
    private Float rating;
    private String message;

    public UUID getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(UUID commentOwner) {
        this.commentOwner = commentOwner;
    }

    public String getCommentOwnerFullname() {
        return commentOwnerFullname;
    }

    public void setCommentOwnerFullname(String commentOwnerFullname) {
        this.commentOwnerFullname = commentOwnerFullname;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
