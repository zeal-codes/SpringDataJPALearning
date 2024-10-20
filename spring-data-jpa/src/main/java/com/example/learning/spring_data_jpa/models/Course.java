package com.example.learning.spring_data_jpa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {
   

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private String title;

    @ManyToMany // Owner/Maintainer of relationship
    @JoinTable(
        name = "author_course_id_map",
        joinColumns = {
            @JoinColumn(name = "course_id")  // CAN ONLY BE DONE WITH PK!
        }, // List of columns to be joined  from Course..
        inverseJoinColumns = {
            @JoinColumn(name = "author_id") // CAN ONLY BE DONE WITH PK!
            // @JoinColumn(name = "author_email") <== NOT POSSIBLE!
        }  // List of columns to be joined from Author..
    )
    private List<Author> authors;


    @OneToMany(mappedBy = "course")
    private List<Section> sections;

}
