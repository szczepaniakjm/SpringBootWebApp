package com.app.dto;

import com.app.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.pl.NIP;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgrammerSkillsDto {
    private Long id;

    @Pattern(regexp = "[A-Z]+", message = "Name is not correct")
    private String name;

    @Pattern(regexp = "[A-Z]{4,}", message = "Surname is not correct 1")
    @Length(min = 4, message = "Surname is not correct 2")
    private String surname;

    private Integer age;
    private BigDecimal salary;

    @PastOrPresent(message = "Hire date mus be from past")
    private LocalDate hireDate;

    private Gender gender;
    private Integer experience;
    private String photo;

    private List<String> skills;
    private CompanyDto companyDto;
    private MultipartFile multipartFile;
}
