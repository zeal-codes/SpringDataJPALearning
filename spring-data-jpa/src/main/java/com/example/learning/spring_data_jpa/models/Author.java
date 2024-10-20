package com.example.learning.spring_data_jpa.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// @Builder
@SuperBuilder // to be used when it inherits from another class..
@EqualsAndHashCode(callSuper = true) // to be used when it inherits from another class..
@Table(
    name = "Author"
)
public class Author extends BaseEntity{


    /* 
    ================================================================
    CAN ADD PK TO BASE_ENTITY TOO IF common, hence added this time for demo
    ================================================================
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

    */
    private String name;
    @Column(
        name = "emailAddress",
        nullable = false,
        unique = true
    )
    private String email;
    private int age;

    // In our case, Course table will be holding the FK attribute in ref. to Author's id (the PK)
    @ManyToMany(mappedBy = "authors") // field name in entity who's table going to hold it as a FK
    private List<Course> courses;


    // Below properties might be maintained for all entities, hence must be a part of porent entity!
    // @Column(
    //     updatable = false, // only allowd to be created, never allow future updates to it
    //     nullable = false 
    // )
    // private LocalDateTime createdAt;
    

    // @Column(
    //     insertable = false,
    //     nullable = true // null indicates that record had never been updated.
    // )
    // private LocalDateTime lastModifiedAt;
}
