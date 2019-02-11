package com.app.repository;

import com.app.model.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
    Optional<Programmer> findByNameContainingAndSurnameStartingWith(String nameExpr, String surnameExpr);

    @Query("select p from Programmer p where p.age between ?1 and ?2 and p.name like ?3%")
    List<Programmer> findByParams(Integer ageMin, Integer ageMax, String nameExpr);
}
