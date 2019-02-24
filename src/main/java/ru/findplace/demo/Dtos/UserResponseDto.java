package ru.findplace.demo.Dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponseDto {
    /**
     * Статус создан или не создан пользователь
     */
    boolean status;
    /**
     * Сообщение о статусе регистрации
     */
    String message;
}
