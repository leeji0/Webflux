package com.icon.webflux.userservice.util;

import com.icon.webflux.userservice.dto.TransactionRequestDto;
import com.icon.webflux.userservice.dto.TransactionResponseDto;
import com.icon.webflux.userservice.dto.TransactionStatus;
import com.icon.webflux.userservice.dto.UserDto;
import com.icon.webflux.userservice.entity.User;
import com.icon.webflux.userservice.entity.UserTransaction;
import java.time.LocalDateTime;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    public static UserTransaction toEntity(TransactionRequestDto requestDto){
        UserTransaction ut = new UserTransaction();
        ut.setUserId(requestDto.getUserId());
        ut.setAmount(requestDto.getAmount());
        ut.setTransactionDate(LocalDateTime.now());
        return ut;
    }

    //each transaction
    public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status){
        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setAmount(requestDto.getAmount());
        responseDto.setUserId(requestDto.getUserId());
        responseDto.setStatus(status);
        return responseDto;
    }

}
