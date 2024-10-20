package com.example.learning.spring_data_jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Resource {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String url;
    private int size;


    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
