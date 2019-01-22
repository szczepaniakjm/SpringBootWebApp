package com.app.dto;

import com.app.model.Company;
import com.app.model.Gender;
import com.app.model.Skill;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgrammerDto {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;
    private LocalDate hireDate;
    private Gender gender;
    private Integer experience;
    private String photo;
    private Set<SkillDto> skillsDto;
    private CompanyDto companyDto;
}
