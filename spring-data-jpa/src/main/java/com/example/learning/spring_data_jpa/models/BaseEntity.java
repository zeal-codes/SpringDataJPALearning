package com.example.learning.spring_data_jpa.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass // Doesnt have an @Entity annotation, since not going to store in DB
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseEntity {
    
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

    private String createdBy;
    private String lastModifiedBy;
}
