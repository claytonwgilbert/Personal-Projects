package com.cg.spring.data.jpa.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence")
    private Long courseMaterialId;

    private String materialUrl;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false // - Can't save a CourseMaterial object without a course
    )
    @JoinColumn(
            name = "course_id", //<-- Name of the column that will be created to host the foreign key in the course material table
            referencedColumnName = "courseId" //<-- References the courseId attribute in Course class
    )
    private Course course;
}
