package com.cg.classrosterfullstackapp.students;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private Long id;
    private String name;
    private String email;
    private Gender gender;
}
