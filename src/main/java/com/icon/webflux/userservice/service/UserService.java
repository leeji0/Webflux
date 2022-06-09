package com.icon.webflux.userservice.service;

import com.icon.webflux.userservice.dto.UserDto;
import com.icon.webflux.userservice.repository.UserRepository;
import com.icon.webflux.userservice.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<UserDto> all(){
        return this.userRepository.findAll()
            .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> getUserById(final int userId){
        return this.userRepository.findById(userId)
            .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> createUser(Mono<UserDto> userDtoMono){
        return userDtoMono
            .map(EntityDtoUtil::toEntity)
            .flatMap(this.userRepository::save) //mono라서 flatmap사용한듯..?
            .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDto> updateUser(int id, Mono<UserDto> userDtoMono){
        return this.userRepository.findById(id)
            .flatMap(u -> userDtoMono               //u 는 아마 user reponse
                .map(EntityDtoUtil::toEntity)
                .doOnNext(e -> e.setId(id)))    //e는 entity
            .flatMap(this.userRepository::save)
            .map(EntityDtoUtil::toDto);
    }

    public Mono<Void> deleteUser(int id){
        return this.userRepository.deleteById(id);
    }
}
