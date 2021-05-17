package com.rog.teach.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ErrorMessage {
    ERROR_DUBL_USER("Пользователь c таким именем уже есть!", 1),
    ERROR_NOT_FOUND_USER("Пользователь не найден!", null),
    ERROR_DUBL_USER_EMAIL("Пользователь с таким email уже есть!", 2),
    ERROR_ACTUVATION_ACCOUNT("Пользователь не активирован, зайдите на почту для подтверждения вашей учетной записи", null);

    private String text;

    private Integer identificatorError;
}