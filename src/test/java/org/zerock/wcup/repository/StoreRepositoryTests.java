package org.zerock.wcup.repository;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zerock.wcup.domain.Store;

@SpringBootTest
@Log4j2
public class StoreRepositoryTests {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void testInertStore0() {

        Store store = Store.builder()
                .title("ADMIN")
                .pw(passwordEncoder.encode("1111"))
                .build();


        storeRepository.save(store);

    }
}
