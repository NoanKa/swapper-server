package com.noanka.swapper.module.profile.controller.http.dto;

import java.time.LocalDate;

public class UserDto {
    private String fullName;
    private LocalDate birthdate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
