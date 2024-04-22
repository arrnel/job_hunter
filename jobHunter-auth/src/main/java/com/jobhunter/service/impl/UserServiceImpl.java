package com.jobhunter.service.impl;

import com.jobhunter.model.Authority;
import com.jobhunter.model.AuthorityEntity;
import com.jobhunter.model.UserEntity;
import com.jobhunter.model.UserJson;
import com.jobhunter.repository.UserRepository;
import com.jobhunter.service.UserService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final KafkaTemplate<String, UserJson> kafkaTemplate;


    @Transactional
    public @Nonnull String registerUser(@Nonnull String username, @Nonnull String password) {

        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .enabled(true)
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .authorities(
                        List.of(
                                AuthorityEntity
                                        .builder()
                                        .authority(Authority.read)
                                        .build()
                                , AuthorityEntity
                                        .builder()
                                        .authority(Authority.write)
                                        .build()
                        )
                )
                .build();

        String savedUser = userRepository.save(userEntity).getUsername();
        kafkaTemplate.send("users", UserJson.builder().username(savedUser).build());

        log.info("### Kafka topic [users] sent message: {}", savedUser);
        return savedUser;

    }

}

