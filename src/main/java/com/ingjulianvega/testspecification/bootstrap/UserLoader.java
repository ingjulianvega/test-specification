package com.ingjulianvega.testspecification.bootstrap;

import com.ingjulianvega.testspecification.domain.UserEntity;
import com.ingjulianvega.testspecification.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class UserLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            loadMaritalStatusObjects();
        }
    }

    private void loadMaritalStatusObjects() {
        userRepository.saveAll(Arrays.asList(
                UserEntity.builder().firstName("Elena").lastName("Aguilar").email("ea@gmail.com").age(21).build(),
                UserEntity.builder().firstName("Marta").lastName("Aguilera").email("ma@gmail.com").age(12).build(),
                UserEntity.builder().firstName("Eva").lastName("Arenas").email("ear@gmail.com").age(42).build(),
                UserEntity.builder().firstName("Lucia").lastName("Barrera").email("lb@gmail.com").age(32).build(),
                UserEntity.builder().firstName("Maria").lastName("Barrera").email("lb@gmail.com").age(32).build(),
                UserEntity.builder().firstName("Diego").lastName("Aguilar").email("da@gmail.com").age(15).build(),
                UserEntity.builder().firstName("Pablo").lastName("Cabrera").email("pc@gmail.com").age(26).build(),
                UserEntity.builder().firstName("Daniel").lastName("Duran").email("dd@gmail.com").age(36).build(),
                UserEntity.builder().firstName("Javier").lastName("Hernandez").email("jh@gmail.com").age(36).build(),
                UserEntity.builder().firstName("David").lastName("Junco").email("dj@gmail.com").age(42).build(),
                UserEntity.builder().firstName("José").lastName("Ramirez").email("jr@gmail.com").age(43).build()


        ));
    }
}
