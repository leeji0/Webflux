package com.icon.webflux.userservice.service;

import com.icon.webflux.userservice.dto.TransactionRequestDto;
import com.icon.webflux.userservice.dto.TransactionResponseDto;
import com.icon.webflux.userservice.dto.TransactionStatus;
import com.icon.webflux.userservice.entity.UserTransaction;
import com.icon.webflux.userservice.repository.UserRepository;
import com.icon.webflux.userservice.repository.UserTransactionRepository;
import com.icon.webflux.userservice.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final UserRepository userRepository;
    private final UserTransactionRepository transactionRepository;

    public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto){
        return this.userRepository.updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
                        .filter(Boolean::booleanValue)
                        .map(b -> EntityDtoUtil.toEntity(requestDto))
                        .flatMap(this.transactionRepository::save)
                        .map(ut -> EntityDtoUtil.toDto(requestDto, TransactionStatus.APPROVED))
                        .defaultIfEmpty(EntityDtoUtil.toDto(requestDto, TransactionStatus.DECLINED));
    }

    public Flux<UserTransaction> getByUserId(int userId){
        return this.transactionRepository.findByUserId(userId);
    }

}
