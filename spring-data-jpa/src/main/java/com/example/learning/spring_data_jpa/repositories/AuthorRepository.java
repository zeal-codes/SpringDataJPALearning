package com.example.learning.spring_data_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learning.spring_data_jpa.models.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    
}
