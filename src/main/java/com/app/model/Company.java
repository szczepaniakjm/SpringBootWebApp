package com.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data //generuje rowniez konstruktor bezargumentowy
@AllArgsConstructor
// @NoArgsConstructor
@Builder
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Programmer> programmers;
}
