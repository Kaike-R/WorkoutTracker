package br.com.kaikedev.workouttracker.Repositories;

import br.com.kaikedev.workouttracker.Entities.Users;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class UserRepoTest {

    @Autowired
    UserRepo userRepo;

    @Autowired
    EntityManager em;


    @Test
    @DisplayName("Should get User Succefully")
    void findByEmail() {
        Users user = new Users(1, "test", "123", "test@test.com", LocalDateTime.now(), LocalDateTime.now());
        em.clear();
        createUser(user);

        Users result = userRepo.findByEmail("test@test.com");

        assertThat(result).isNotNull();
    }

    private Users createUser(Users user) {
        em.merge(user);
        return user;
    }
}