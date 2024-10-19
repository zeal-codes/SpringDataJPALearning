package com.example.learning.spring_data_jpa.models;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue // By default : AUTO
    // SEQUENCE
    // @GeneratedValue(
    //     strategy = GenerationType.SEQUENCE,
    //     generator = "author_sequence_generator" // MUST MATCH

    // )
    // @SequenceGenerator(
    //     name = "author_sequence_generator", // MUST MATCH
    //     sequenceName = "author_sequence_strat",
    //     allocationSize = 1, // step size (DEF=50)
    //     initialValue = 68 // intial val (DEF=1)
    // )

    // TABLE
    // @GeneratedValue(
    //     strategy = GenerationType.TABLE,
    //     generator = "author_table_generator" // MUST MATCH
    // )
    // @TableGenerator(
    //     name = "author_table_generator", // MUST MATCH
    //     table = "author_id_generator_table",
    //     pkColumnName = "id_name",
    //     valueColumnName  = "id_value",
    //     allocationSize = 1
    // )
    private Integer id;
    private String name;
    @Column(
        name = "emailAddress",
        nullable = false,
        unique = true
    )
    private String email;
    private int age;


    @Column(
        updatable = false, // only allowd to be created, never allow future updates to it
        nullable = false 
    )
    private LocalDateTime createdAt;
    

    @Column(
        insertable = false,
        nullable = true // null indicates that record had never been updated.
    )
    private LocalDateTime lastModifiedAt;
}
