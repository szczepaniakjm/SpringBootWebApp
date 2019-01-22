package com.app.dto;

import com.app.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;
    private LocalDate hireDate;
    private Gender gender;
    private Integer experience;
    private String photo;
    private List<String> skills;
    private CompanyDto companyDto;
    private MultipartFile multipartFile;
}
