package com.noanka.swapper.module.profile.controller.http.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UpdateUserProfileRequest {
    @Size(max = 20)
    private String name;
    @Size(max = 20)
    private String lastName;
    private Long birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Long birthdate) {
        this.birthdate = birthdate;
    }
}
