package com.cg.springrecipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"recipes"}) //Excluding due to bidirectional configuration, results in compiler error
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
