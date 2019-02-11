package com.app.service;

import com.app.dto.CompanyDto;
import com.app.dto.ProgrammerDto;
import com.app.dto.ProgrammerSkillsDto;
import com.app.dto.SkillDto;
import com.app.model.Company;
import com.app.model.Programmer;
import com.app.model.Skill;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ModelMapper {

    public CompanyDto fromCompanyToCompanyDto(Company company) {
        return company == null ? null : CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }

    public Company fromCompanyDtoToCompany(CompanyDto companyDto) {
        return companyDto == null ? null : Company.builder()
                .id(companyDto.getId())
                .name(companyDto.getName())
                .programmers(new HashSet<>())
                .build();
    }

    public SkillDto fromSkillToSkillDto(Skill skill) {
        return skill == null ? null : SkillDto.builder()
                .id(skill.getId())
                .description(skill.getDescription())
                .skill(skill.getSkill())
                .build();
    }

    public Skill fromSkillDtoToSkill(SkillDto skillDto) {
        return skillDto == null ? null : Skill.builder()
                .id(skillDto.getId())
                .description(skillDto.getDescription())
                .skill(skillDto.getSkill())
                .build();
    }

    public ProgrammerDto fromProgrammerToProgrammerDto(Programmer programmer){
        return programmer == null ? null : ProgrammerDto.builder()
                .id(programmer.getId())
                .name(programmer.getName())
                .surname(programmer.getSurname())
                .age(programmer.getAge())
                .salary(programmer.getSalary())
                .hireDate(programmer.getHireDate())
                .gender(programmer.getGender())
                .experience(programmer.getExperience())
                .photo(programmer.getPhoto())
                .skillsDto(programmer.getSkills() == null ? null : programmer.getSkills().stream().map(this::fromSkillToSkillDto).collect(Collectors.toSet()))
                .companyDto(fromCompanyToCompanyDto(programmer.getCompany()))
                .build();
    }

    public ProgrammerSkillsDto fromProgrammerToProgrammerSkillsDto(Programmer programmer){
        return programmer == null ? null : ProgrammerSkillsDto.builder()
                .id(programmer.getId())
                .name(programmer.getName())
                .surname(programmer.getSurname())
                .age(programmer.getAge())
                .salary(programmer.getSalary())
                .hireDate(programmer.getHireDate())
                .gender(programmer.getGender())
                .experience(programmer.getExperience())
                .photo(programmer.getPhoto())
                .skills(programmer.getSkills() == null ? null : programmer.getSkills().stream().map(Skill::getSkill).collect(Collectors.toList()))
                .companyDto(fromCompanyToCompanyDto(programmer.getCompany()))
                .build();
    }

    public Programmer fromProgrammerSkillsDtoToProgrammer(ProgrammerSkillsDto programmerSkillsDto){
        return programmerSkillsDto == null ? null : Programmer.builder()
                .id(programmerSkillsDto.getId())
                .name(programmerSkillsDto.getName())
                .surname(programmerSkillsDto.getSurname())
                .age(programmerSkillsDto.getAge())
                .salary(programmerSkillsDto.getSalary())
                .hireDate(programmerSkillsDto.getHireDate())
                .gender(programmerSkillsDto.getGender())
                .experience(programmerSkillsDto.getExperience())
                .photo(programmerSkillsDto.getPhoto())
                .skills(programmerSkillsDto.getSkills() == null ? null : programmerSkillsDto.getSkills().stream().map(s -> Skill.builder().skill(s).build()).collect(Collectors.toSet()))
                .company(fromCompanyDtoToCompany(programmerSkillsDto.getCompanyDto()))
                .build();
    }

    public Programmer fromProgrammerDtoToProgrammer(ProgrammerDto programmerDto){
        return programmerDto == null ? null : Programmer.builder()
                .id(programmerDto.getId())
                .name(programmerDto.getName())
                .surname(programmerDto.getSurname())
                .age(programmerDto.getAge())
                .salary(programmerDto.getSalary())
                .hireDate(programmerDto.getHireDate())
                .gender(programmerDto.getGender())
                .experience(programmerDto.getExperience())
                .photo(programmerDto.getPhoto())
                .skills(programmerDto.getSkillsDto() == null ? null : programmerDto.getSkillsDto().stream().map(this::fromSkillDtoToSkill).collect(Collectors.toSet()))
                .company(fromCompanyDtoToCompany(programmerDto.getCompanyDto()))
                .build();
    }

}
