package com.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue
    private Long id;
    private String skill;
    private String description;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "skills")
    private Set<Programmer> programmers;
}
