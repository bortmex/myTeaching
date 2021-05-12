package com.rog.teach.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
public enum  ErrorMessage {
    ERROR_DUBL_USER("Пользователь c таким именем уже есть!"),
    ERROR_NOT_FOUND_USER("Пользователь не найден!"),
    ERROR_DUBL_USER_EMAIL("Пользователь с таким email уже есть!"),
    ERROR_ACTUVATION_ACCOUNT("Пользователь не активирован, зайдите на почту для подтверждения вашей учетной записи");

    private String text;

    public String getText() {
        return text;
    }
}