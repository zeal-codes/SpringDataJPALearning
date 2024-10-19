package com.example.learning.spring_data_jpa.repositories;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.learning.spring_data_jpa.models.Author;

@SpringBootTest
// @DataJpaTest ==> data removed post test
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void insertAuthors() {
        Author author = Author.builder()
                        .name("HC Verma")
                        .age(59)
                        .email("iitjee@gmail.com")
                        .createdAt(LocalDateTime.now())
                        .build();
        authorRepository.save(author);
    }
    
}
